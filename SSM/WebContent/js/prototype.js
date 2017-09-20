/*--------------------------------------------------------------------------*/
/* Modify By seaman , yesun 2006-5-25
 * Ajax Base
/*--------------------------------------------------------------------------*/
/*  Prototype JavaScript framework, version 1.5.0_pre1
 *  (c) 2005 Sam Stephenson <sam@conio.net>
 *
 *  Prototype is freely distributable under the terms of an MIT-style license.
 *  For details, see the Prototype web site: http://prototype.conio.net/
 *
/*--------------------------------------------------------------------------*/

var Prototype = {
  Version: '1.5.0_pre1',
  ScriptFragment: '(?:<script.*?>)((\n|\r|.)*?)(?:<\/script>)',

  emptyFunction: function() {},
  K: function(x) {return x}
}

var Class = {
  create: function() {
    return function() {
      this.initialize.apply(this, arguments);
    }
  }
}

var Abstract = new Object();

Object.extend = function(destination, source) {
  for (property in source) {
    destination[property] = source[property];
  }
  return destination;
}

Object.inspect = function(object) {
  try {
    if (object == undefined) return 'undefined';
    if (object == null) return 'null';
    return object.inspect ? object.inspect() : object.toString();
  } catch (e) {
    if (e instanceof RangeError) return '...';
    throw e;
  }
}

Function.prototype.bind = function() {
  var __method = this, args = $A(arguments), object = args.shift();
  return function() {
    return __method.apply(object, args.concat($A(arguments)));
  }
}

Function.prototype.bindAsEventListener = function(object) {
  var __method = this;
  return function(event) {
    return __method.call(object, event || window.event);
  }
}

Object.extend(Number.prototype, {
  toColorPart: function() {
    var digits = this.toString(16);
    if (this < 16) return '0' + digits;
    return digits;
  },

  succ: function() {
    return this + 1;
  },

  times: function(iterator) {
    $R(0, this, true).each(iterator);
    return this;
  }
});

var Try = {
  these: function() {
    var returnValue;

    for (var i = 0; i < arguments.length; i++) {
      var lambda = arguments[i];
      try {
        returnValue = lambda();
        break;
      } catch (e) {}
    }

    return returnValue;
  }
}

/*--------------------------------------------------------------------------*/

var PeriodicalExecuter = Class.create();
PeriodicalExecuter.prototype = {
  initialize: function(callback, frequency) {
    this.callback = callback;
    this.frequency = frequency;
    this.currentlyExecuting = false;

    this.registerCallback();
  },

  registerCallback: function() {
    setInterval(this.onTimerEvent.bind(this), this.frequency * 1000);
  },

  onTimerEvent: function() {
    if (!this.currentlyExecuting) {
      try {
        this.currentlyExecuting = true;
        this.callback();
      } finally {
        this.currentlyExecuting = false;
      }
    }
  }
}
Object.extend(String.prototype, {
  gsub: function(pattern, replacement) {
    var result = '', source = this, match;
    replacement = arguments.callee.prepareReplacement(replacement);

    while (source.length > 0) {
      if (match = source.match(pattern)) {
        result += source.slice(0, match.index);
        result += (replacement(match) || '').toString();
        source  = source.slice(match.index + match[0].length);
      } else {
        result += source, source = '';
      }
    }
    return result;
  },

  sub: function(pattern, replacement, count) {
    replacement = this.gsub.prepareReplacement(replacement);
    count = count === undefined ? 1 : count;

    return this.gsub(pattern, function(match) {
      if (--count < 0) return match[0];
      return replacement(match);
    });
  },

  scan: function(pattern, iterator) {
    this.gsub(pattern, iterator);
    return this;
  },

  truncate: function(length, truncation) {
    length = length || 30;
    truncation = truncation === undefined ? '...' : truncation;
    return this.length > length ?
      this.slice(0, length - truncation.length) + truncation : this;
  },

  strip: function() {
    return this.replace(/^\s+/, '').replace(/\s+$/, '');
  },

  stripTags: function() {
    return this.replace(/<\/?[^>]+>/gi, '');
  },

  stripScripts: function() {
    return this.replace(new RegExp(Prototype.ScriptFragment, 'img'), '');
  },

  extractScripts: function() {
    var matchAll = new RegExp(Prototype.ScriptFragment, 'img');
    var matchOne = new RegExp(Prototype.ScriptFragment, 'im');
    return (this.match(matchAll) || []).map(function(scriptTag) {
      return (scriptTag.match(matchOne) || ['', ''])[1];
    });
  },

  evalScripts: function() {
    return this.extractScripts().map(eval);
  },

  escapeHTML: function() {
    var div = document.createElement('div');
    var text = document.createTextNode(this);
    div.appendChild(text);
    return div.innerHTML;
  },

  unescapeHTML: function() {
    var div = document.createElement('div');
    div.innerHTML = this.stripTags();
    return div.childNodes[0] ? div.childNodes[0].nodeValue : '';
  },

  toQueryParams: function() {
    var pairs = this.match(/^\??(.*)$/)[1].split('&');
    return pairs.inject({}, function(params, pairString) {
      var pair = pairString.split('=');
      params[pair[0]] = pair[1];
      return params;
    });
  },

  toArray: function() {
    return this.split('');
  },

  camelize: function() {
    var oStringList = this.split('-');
    if (oStringList.length == 1) return oStringList[0];

    var camelizedString = this.indexOf('-') == 0
      ? oStringList[0].charAt(0).toUpperCase() + oStringList[0].substring(1)
      : oStringList[0];

    for (var i = 1, len = oStringList.length; i < len; i++) {
      var s = oStringList[i];
      camelizedString += s.charAt(0).toUpperCase() + s.substring(1);
    }

    return camelizedString;
  },

  inspect: function() {
    return "'" + this.replace(/\\/g, '\\\\').replace(/'/g, '\\\'') + "'";
  }
});

String.prototype.gsub.prepareReplacement = function(replacement) {
  if (typeof replacement == 'function') return replacement;
  var template = new Template(replacement);
  return function(match) { return template.evaluate(match) };
}

String.prototype.parseQuery = String.prototype.toQueryParams;

var Template = Class.create();
Template.Pattern = /(^|.|\r|\n)(#\{(.*?)\})/;
Template.prototype = {
  initialize: function(template, pattern) {
    this.template = template.toString();
    this.pattern  = pattern || Template.Pattern;
  },

  evaluate: function(object) {
    return this.template.gsub(this.pattern, function(match) {
      var before = match[1];
      if (before == '\\') return match[2];
      return before + (object[match[3]] || '').toString();
    });
  }
}

var $break    = new Object();
var $continue = new Object();

var Enumerable = {
  each: function(iterator) {
    var index = 0;
    try {
      this._each(function(value) {
        try {
          iterator(value, index++);
        } catch (e) {
          if (e != $continue) throw e;
        }
      });
    } catch (e) {
      if (e != $break) throw e;
    }
  },

  all: function(iterator) {
    var result = true;
    this.each(function(value, index) {
      result = result && !!(iterator || Prototype.K)(value, index);
      if (!result) throw $break;
    });
    return result;
  },

  any: function(iterator) {
    var result = true;
    this.each(function(value, index) {
      if (result = !!(iterator || Prototype.K)(value, index))
        throw $break;
    });
    return result;
  },

  collect: function(iterator) {
    var results = [];
    this.each(function(value, index) {
      results.push(iterator(value, index));
    });
    return results;
  },

  detect: function (iterator) {
    var result;
    this.each(function(value, index) {
      if (iterator(value, index)) {
        result = value;
        throw $break;
      }
    });
    return result;
  },

  findAll: function(iterator) {
    var results = [];
    this.each(function(value, index) {
      if (iterator(value, index))
        results.push(value);
    });
    return results;
  },

  grep: function(pattern, iterator) {
    var results = [];
    this.each(function(value, index) {
      var stringValue = value.toString();
      if (stringValue.match(pattern))
        results.push((iterator || Prototype.K)(value, index));
    })
    return results;
  },

  include: function(object) {
    var found = false;
    this.each(function(value) {
      if (value == object) {
        found = true;
        throw $break;
      }
    });
    return found;
  },

  inject: function(memo, iterator) {
    this.each(function(value, index) {
      memo = iterator(memo, value, index);
    });
    return memo;
  },

  invoke: function(method) {
    var args = $A(arguments).slice(1);
    return this.collect(function(value) {
      return value[method].apply(value, args);
    });
  },

  max: function(iterator) {
    var result;
    this.each(function(value, index) {
      value = (iterator || Prototype.K)(value, index);
      if (value >= (result || value))
        result = value;
    });
    return result;
  },

  min: function(iterator) {
    var result;
    this.each(function(value, index) {
      value = (iterator || Prototype.K)(value, index);
      if (value <= (result || value))
        result = value;
    });
    return result;
  },

  partition: function(iterator) {
    var trues = [], falses = [];
    this.each(function(value, index) {
      ((iterator || Prototype.K)(value, index) ?
        trues : falses).push(value);
    });
    return [trues, falses];
  },

  pluck: function(property) {
    var results = [];
    this.each(function(value, index) {
      results.push(value[property]);
    });
    return results;
  },

  reject: function(iterator) {
    var results = [];
    this.each(function(value, index) {
      if (!iterator(value, index))
        results.push(value);
    });
    return results;
  },

  sortBy: function(iterator) {
    return this.collect(function(value, index) {
      return {value: value, criteria: iterator(value, index)};
    }).sort(function(left, right) {
      var a = left.criteria, b = right.criteria;
      return a < b ? -1 : a > b ? 1 : 0;
    }).pluck('value');
  },

  toArray: function() {
    return this.collect(Prototype.K);
  },

  zip: function() {
    var iterator = Prototype.K, args = $A(arguments);
    if (typeof args.last() == 'function')
      iterator = args.pop();

    var collections = [this].concat(args).map($A);
    return this.map(function(value, index) {
      return iterator(collections.pluck(index));
    });
  },

  inspect: function() {
    return '#<Enumerable:' + this.toArray().inspect() + '>';
  }
}

Object.extend(Enumerable, {
  map:     Enumerable.collect,
  find:    Enumerable.detect,
  select:  Enumerable.findAll,
  member:  Enumerable.include,
  entries: Enumerable.toArray
});
var $A = Array.from = function(iterable) {
  if (!iterable) return [];
  if (iterable.toArray) {
    return iterable.toArray();
  } else {
    var results = [];
    for (var i = 0; i < iterable.length; i++)
      results.push(iterable[i]);
    return results;
  }
}

Object.extend(Array.prototype, Enumerable);

Array.prototype._reverse = Array.prototype.reverse;

Object.extend(Array.prototype, {
  _each: function(iterator) {
    for (var i = 0; i < this.length; i++)
      iterator(this[i]);
  },

  clear: function() {
    this.length = 0;
    return this;
  },

  first: function() {
    return this[0];
  },

  last: function() {
    return this[this.length - 1];
  },

  compact: function() {
    return this.select(function(value) {
      return value != undefined || value != null;
    });
  },

  flatten: function() {
    return this.inject([], function(array, value) {
      return array.concat(value.constructor == Array ?
        value.flatten() : [value]);
    });
  },

  without: function() {
    var values = $A(arguments);
    return this.select(function(value) {
      return !values.include(value);
    });
  },

  indexOf: function(object) {
    for (var i = 0; i < this.length; i++)
      if (this[i] == object) return i;
    return -1;
  },

  reverse: function(inline) {
    return (inline !== false ? this : this.toArray())._reverse();
  },

  shift: function() {
    var result = this[0];
    for (var i = 0; i < this.length - 1; i++)
      this[i] = this[i + 1];
    this.length--;
    return result;
  },

  inspect: function() {
    return '[' + this.map(Object.inspect).join(', ') + ']';
  }
});
var Hash = {
  _each: function(iterator) {
    for (key in this) {
      var value = this[key];
      if (typeof value == 'function') continue;

      var pair = [key, value];
      pair.key = key;
      pair.value = value;
      iterator(pair);
    }
  },

  keys: function() {
    return this.pluck('key');
  },

  values: function() {
    return this.pluck('value');
  },

  merge: function(hash) {
    return $H(hash).inject($H(this), function(mergedHash, pair) {
      mergedHash[pair.key] = pair.value;
      return mergedHash;
    });
  },

  toQueryString: function() {
    return this.map(function(pair) {
      return pair.map(encodeURIComponent).join('=');
    }).join('&');
  },

  inspect: function() {
    return '#<Hash:{' + this.map(function(pair) {
      return pair.map(Object.inspect).join(': ');
    }).join(', ') + '}>';
  }
}

function $H(object) {
  var hash = Object.extend({}, object || {});
  Object.extend(hash, Enumerable);
  Object.extend(hash, Hash);
  return hash;
}
ObjectRange = Class.create();
Object.extend(ObjectRange.prototype, Enumerable);
Object.extend(ObjectRange.prototype, {
  initialize: function(start, end, exclusive) {
    this.start = start;
    this.end = end;
    this.exclusive = exclusive;
  },

  _each: function(iterator) {
    var value = this.start;
    do {
      iterator(value);
      value = value.succ();
    } while (this.include(value));
  },

  include: function(value) {
    if (value < this.start)
      return false;
    if (this.exclusive)
      return value < this.end;
    return value <= this.end;
  }
});

var $R = function(start, end, exclusive) {
  return new ObjectRange(start, end, exclusive);
}

var Ajax = {
  getTransport: function() {
    return Try.these(
      function() {return new ActiveXObject('Msxml2.XMLHTTP')},
      function() {return new ActiveXObject('Microsoft.XMLHTTP')},
      function() {return new XMLHttpRequest()}
    ) || false;
  },

  activeRequestCount: 0
}

Ajax.Responders = {
  responders: [],

  _each: function(iterator) {
    this.responders._each(iterator);
  },

  register: function(responderToAdd) {
    if (!this.include(responderToAdd))
      this.responders.push(responderToAdd);
  },

  unregister: function(responderToRemove) {
    this.responders = this.responders.without(responderToRemove);
  },

  dispatch: function(callback, request, transport, json) {
    this.each(function(responder) {
      if (responder[callback] && typeof responder[callback] == 'function') {
        try {
          responder[callback].apply(responder, [request, transport, json]);
        } catch (e) {}
      }
    });
  }
};

Object.extend(Ajax.Responders, Enumerable);

Ajax.Responders.register({
  onCreate: function() {
    Ajax.activeRequestCount++;
  },

  onComplete: function() {
    Ajax.activeRequestCount--;
  }
});

Ajax.Base = function() {};
Ajax.Base.prototype = {
  setOptions: function(options) {
    this.options = {
      method:       'post',
      asynchronous: true,
      parameters:   ''
    }
    Object.extend(this.options, options || {});
  },

  responseIsSuccess: function() {
    return this.transport.status == undefined
        || this.transport.status == 0
        || (this.transport.status >= 200 && this.transport.status < 300);
  },

  responseIsFailure: function() {
    return !this.responseIsSuccess();
  }
}

Ajax.Request = Class.create();
Ajax.Request.Events =
  ['Uninitialized', 'Loading', 'Loaded', 'Interactive', 'Complete'];

Ajax.Request.prototype = Object.extend(new Ajax.Base(), {
  initialize: function(url, options) {
    this.transport = Ajax.getTransport();
    this.setOptions(options);
    this.request(url);
  },

  request: function(url) {
    var parameters = this.options.parameters || '';
    if (parameters.length > 0) parameters += '&_=';

    try {
      this.url = url;
      if (this.options.method == 'get' && parameters.length > 0)
        this.url += (this.url.match(/\?/) ? '&' : '?') + parameters;

      Ajax.Responders.dispatch('onCreate', this, this.transport);

      this.transport.open(this.options.method, this.url,
        this.options.asynchronous);

      if (this.options.asynchronous) {
        this.transport.onreadystatechange = this.onStateChange.bind(this);
        setTimeout((function() {this.respondToReadyState(1)}).bind(this), 10);
      }

      this.setRequestHeaders();

      var body = this.options.postBody ? this.options.postBody : parameters;
      this.transport.send(this.options.method == 'post' ? body : null);

    } catch (e) {
      this.dispatchException(e);
    }
  },

  setRequestHeaders: function() {
    var requestHeaders =
      ['X-Requested-With', 'XMLHttpRequest',
       'X-Prototype-Version', Prototype.Version,
       'Accept', 'text/javascript, text/html, application/xml, text/xml, */*'];

    if (this.options.method == 'post') {
      requestHeaders.push('Content-type',
        'application/x-www-form-urlencoded');

      /* Force "Connection: close" for Mozilla browsers to work around
       * a bug where XMLHttpReqeuest sends an incorrect Content-length
       * header. See Mozilla Bugzilla #246651.
       */
      if (this.transport.overrideMimeType)
        requestHeaders.push('Connection', 'close');
    }

    if (this.options.requestHeaders)
      requestHeaders.push.apply(requestHeaders, this.options.requestHeaders);

    for (var i = 0; i < requestHeaders.length; i += 2)
      this.transport.setRequestHeader(requestHeaders[i], requestHeaders[i+1]);
  },

  onStateChange: function() {
    var readyState = this.transport.readyState;
    if (readyState != 1)
      this.respondToReadyState(this.transport.readyState);
  },

  header: function(name) {
    try {
      return this.transport.getResponseHeader(name);
    } catch (e) {}
  },

  evalJSON: function() {
    try {
      return eval(this.header('X-JSON'));
    } catch (e) {}
  },

  evalResponse: function() {
    try {
      return eval(this.transport.responseText);
    } catch (e) {
      this.dispatchException(e);
    }
  },

  respondToReadyState: function(readyState) {
    var event = Ajax.Request.Events[readyState];
    var transport = this.transport, json = this.evalJSON();

    if (event == 'Complete') {
      try {
        (this.options['on' + this.transport.status]
         || this.options['on' + (this.responseIsSuccess() ? 'Success' : 'Failure')]
         || Prototype.emptyFunction)(transport, json);
      } catch (e) {
        this.dispatchException(e);
      }

      if ((this.header('Content-type') || '').match(/^text\/javascript/i))
        this.evalResponse();
    }

    try {
      (this.options['on' + event] || Prototype.emptyFunction)(transport, json);
      Ajax.Responders.dispatch('on' + event, this, transport, json);
    } catch (e) {
      this.dispatchException(e);
    }

    /* Avoid memory leak in MSIE: clean up the oncomplete event handler */
    if (event == 'Complete')
      this.transport.onreadystatechange = Prototype.emptyFunction;
  },

  dispatchException: function(exception) {
    (this.options.onException || Prototype.emptyFunction)(this, exception);
    Ajax.Responders.dispatch('onException', this, exception);
  }
});

Ajax.Updater = Class.create();

Object.extend(Object.extend(Ajax.Updater.prototype, Ajax.Request.prototype), {
  initialize: function(container, url, options) {
    this.containers = {
      success: container.success ? $(container.success) : $(container),
      failure: container.failure ? $(container.failure) :
        (container.success ? null : $(container))
    }

    this.transport = Ajax.getTransport();
    this.setOptions(options);

    var onComplete = this.options.onComplete || Prototype.emptyFunction;
    this.options.onComplete = (function(transport, object) {
      this.updateContent();
      onComplete(transport, object);
    }).bind(this);

    this.request(url);
  },

  updateContent: function() {
    var receiver = this.responseIsSuccess() ?
      this.containers.success : this.containers.failure;
    var response = this.transport.responseText;

    if (!this.options.evalScripts)
      response = response.stripScripts();

    if (receiver) {
      if (this.options.insertion) {
        new this.options.insertion(receiver, response);
      } else {
        Element.update(receiver, response);
      }
    }

    if (this.responseIsSuccess()) {
      if (this.onComplete)
        setTimeout(this.onComplete.bind(this), 10);
    }
  }
});

Ajax.PeriodicalUpdater = Class.create();
Ajax.PeriodicalUpdater.prototype = Object.extend(new Ajax.Base(), {
  initialize: function(container, url, options) {
    this.setOptions(options);
    this.onComplete = this.options.onComplete;

    this.frequency = (this.options.frequency || 2);
    this.decay = (this.options.decay || 1);

    this.updater = {};
    this.container = container;
    this.url = url;

    this.start();
  },

  start: function() {
    this.options.onComplete = this.updateComplete.bind(this);
    this.onTimerEvent();
  },

  stop: function() {
    this.updater.onComplete = undefined;
    clearTimeout(this.timer);
    (this.onComplete || Prototype.emptyFunction).apply(this, arguments);
  },

  updateComplete: function(request) {
    if (this.options.decay) {
      this.decay = (request.responseText == this.lastText ?
        this.decay * this.options.decay : 1);

      this.lastText = request.responseText;
    }
    this.timer = setTimeout(this.onTimerEvent.bind(this),
      this.decay * this.frequency * 1000);
  },

  onTimerEvent: function() {
    this.updater = new Ajax.Updater(this.container, this.url, this.options);
  }
});
function $() {
  var results = [], element;
  for (var i = 0; i < arguments.length; i++) {
    element = arguments[i];
    if (typeof element == 'string')
      element = document.getElementById(element);
    results.push(Element.extend(element));
  }
  return results.length < 2 ? results[0] : results;
}

document.getElementsByClassName = function(className, parentElement) {
  var children = ($(parentElement) || document.body).getElementsByTagName('*');
  return $A(children).inject([], function(elements, child) {
    if (child.className.match(new RegExp("(^|\\s)" + className + "(\\s|$)")))
      elements.push(Element.extend(child));
    return elements;
  });
}

/*--------------------------------------------------------------------------*/

if (!window.Element)
  var Element = new Object();

Element.extend = function(element) {
  if (!element) return;

  if (!element._extended && element.tagName && element != window) {
    var methods = Element.Methods;
    for (property in methods) {
      var value = methods[property];
      if (typeof value == 'function')
        element[property] = value.bind(null, element);
    }
  }

  element._extended = true;
  return element;
}

Element.Methods = {
  visible: function(element) {
    return $(element).style.display != 'none';
  },

  toggle: function() {
    for (var i = 0; i < arguments.length; i++) {
      var element = $(arguments[i]);
      Element[Element.visible(element) ? 'hide' : 'show'](element);
    }
  },

  hide: function() {
    for (var i = 0; i < arguments.length; i++) {
      var element = $(arguments[i]);
      element.style.display = 'none';
    }
  },

  show: function() {
    for (var i = 0; i < arguments.length; i++) {
      var element = $(arguments[i]);
      element.style.display = '';
    }
  },

  remove: function(element) {
    element = $(element);
    element.parentNode.removeChild(element);
  },

  update: function(element, html) {
    $(element).innerHTML = html.stripScripts();
    setTimeout(function() {html.evalScripts()}, 10);
  },

  replace: function(element, html) {
    element = $(element);
    if (element.outerHTML) {
      element.outerHTML = html.stripScripts();
    } else {
      var range = element.ownerDocument.createRange();
      range.selectNodeContents(element);
      element.parentNode.replaceChild(
        range.createContextualFragment(html.stripScripts()), element);
    }
    setTimeout(function() {html.evalScripts()}, 10);
  },

  getHeight: function(element) {
    element = $(element);
    return element.offsetHeight;
  },

  classNames: function(element) {
    return new Element.ClassNames(element);
  },

  hasClassName: function(element, className) {
    if (!(element = $(element))) return;
    return Element.classNames(element).include(className);
  },

  addClassName: function(element, className) {
    if (!(element = $(element))) return;
    return Element.classNames(element).add(className);
  },

  removeClassName: function(element, className) {
    if (!(element = $(element))) return;
    return Element.classNames(element).remove(className);
  },

  // removes whitespace-only text node children
  cleanWhitespace: function(element) {
    element = $(element);
    for (var i = 0; i < element.childNodes.length; i++) {
      var node = element.childNodes[i];
      if (node.nodeType == 3 && !/\S/.test(node.nodeValue))
        Element.remove(node);
    }
  },

  empty: function(element) {
    return $(element).innerHTML.match(/^\s*$/);
  },

  childOf: function(element, ancestor) {
    element = $(element), ancestor = $(ancestor);
    while (element = element.parentNode)
      if (element == ancestor) return true;
    return false;
  },

  scrollTo: function(element) {
    element = $(element);
    var x = element.x ? element.x : element.offsetLeft,
        y = element.y ? element.y : element.offsetTop;
    window.scrollTo(x, y);
  },

  getStyle: function(element, style) {
    element = $(element);
    var value = element.style[style.camelize()];
    if (!value) {
      if (document.defaultView && document.defaultView.getComputedStyle) {
        var css = document.defaultView.getComputedStyle(element, null);
        value = css ? css.getPropertyValue(style) : null;
      } else if (element.currentStyle) {
        value = element.currentStyle[style.camelize()];
      }
    }

    if (window.opera && ['left', 'top', 'right', 'bottom'].include(style))
      if (Element.getStyle(element, 'position') == 'static') value = 'auto';

    return value == 'auto' ? null : value;
  },

  setStyle: function(element, style) {
    element = $(element);
    for (name in style)
      element.style[name.camelize()] = style[name];
  },

  getDimensions: function(element) {
    element = $(element);
    if (Element.getStyle(element, 'display') != 'none')
      return {width: element.offsetWidth, height: element.offsetHeight};

    // All *Width and *Height properties give 0 on elements with display none,
    // so enable the element temporarily
    var els = element.style;
    var originalVisibility = els.visibility;
    var originalPosition = els.position;
    els.visibility = 'hidden';
    els.position = 'absolute';
    els.display = '';
    var originalWidth = element.clientWidth;
    var originalHeight = element.clientHeight;
    els.display = 'none';
    els.position = originalPosition;
    els.visibility = originalVisibility;
    return {width: originalWidth, height: originalHeight};
  },

  makePositioned: function(element) {
    element = $(element);
    var pos = Element.getStyle(element, 'position');
    if (pos == 'static' || !pos) {
      element._madePositioned = true;
      element.style.position = 'relative';
      // Opera returns the offset relative to the positioning context, when an
      // element is position relative but top and left have not been defined
      if (window.opera) {
        element.style.top = 0;
        element.style.left = 0;
      }
    }
  },

  undoPositioned: function(element) {
    element = $(element);
    if (element._madePositioned) {
      element._madePositioned = undefined;
      element.style.position =
        element.style.top =
        element.style.left =
        element.style.bottom =
        element.style.right = '';
    }
  },

  makeClipping: function(element) {
    element = $(element);
    if (element._overflow) return;
    element._overflow = element.style.overflow;
    if ((Element.getStyle(element, 'overflow') || 'visible') != 'hidden')
      element.style.overflow = 'hidden';
  },

  undoClipping: function(element) {
    element = $(element);
    if (element._overflow) return;
    element.style.overflow = element._overflow;
    element._overflow = undefined;
  }
}

Object.extend(Element, Element.Methods);

var Toggle = new Object();
Toggle.display = Element.toggle;

/*--------------------------------------------------------------------------*/

Abstract.Insertion = function(adjacency) {
  this.adjacency = adjacency;
}

Abstract.Insertion.prototype = {
  initialize: function(element, content) {
    this.element = $(element);
    this.content = content.stripScripts();

    if (this.adjacency && this.element.insertAdjacentHTML) {
      try {
        this.element.insertAdjacentHTML(this.adjacency, this.content);
      } catch (e) {
        if (this.element.tagName.toLowerCase() == 'tbody') {
          this.insertContent(this.contentFromAnonymousTable());
        } else {
          throw e;
        }
      }
    } else {
      this.range = this.element.ownerDocument.createRange();
      if (this.initializeRange) this.initializeRange();
      this.insertContent([this.range.createContextualFragment(this.content)]);
    }

    setTimeout(function() {content.evalScripts()}, 10);
  },

  contentFromAnonymousTable: function() {
    var div = document.createElement('div');
    div.innerHTML = '<table><tbody>' + this.content + '</tbody></table>';
    return $A(div.childNodes[0].childNodes[0].childNodes);
  }
}

var Insertion = new Object();

Insertion.Before = Class.create();
Insertion.Before.prototype = Object.extend(new Abstract.Insertion('beforeBegin'), {
  initializeRange: function() {
    this.range.setStartBefore(this.element);
  },

  insertContent: function(fragments) {
    fragments.each((function(fragment) {
      this.element.parentNode.insertBefore(fragment, this.element);
    }).bind(this));
  }
});

Insertion.Top = Class.create();
Insertion.Top.prototype = Object.extend(new Abstract.Insertion('afterBegin'), {
  initializeRange: function() {
    this.range.selectNodeContents(this.element);
    this.range.collapse(true);
  },

  insertContent: function(fragments) {
    fragments.reverse(false).each((function(fragment) {
      this.element.insertBefore(fragment, this.element.firstChild);
    }).bind(this));
  }
});

Insertion.Bottom = Class.create();
Insertion.Bottom.prototype = Object.extend(new Abstract.Insertion('beforeEnd'), {
  initializeRange: function() {
    this.range.selectNodeContents(this.element);
    this.range.collapse(this.element);
  },

  insertContent: function(fragments) {
    fragments.each((function(fragment) {
      this.element.appendChild(fragment);
    }).bind(this));
  }
});

Insertion.After = Class.create();
Insertion.After.prototype = Object.extend(new Abstract.Insertion('afterEnd'), {
  initializeRange: function() {
    this.range.setStartAfter(this.element);
  },

  insertContent: function(fragments) {
    fragments.each((function(fragment) {
      this.element.parentNode.insertBefore(fragment,
        this.element.nextSibling);
    }).bind(this));
  }
});

/*--------------------------------------------------------------------------*/

Element.ClassNames = Class.create();
Element.ClassNames.prototype = {
  initialize: function(element) {
    this.element = $(element);
  },

  _each: function(iterator) {
    this.element.className.split(/\s+/).select(function(name) {
      return name.length > 0;
    })._each(iterator);
  },

  set: function(className) {
    this.element.className = className;
  },

  add: function(classNameToAdd) {
    if (this.include(classNameToAdd)) return;
    this.set(this.toArray().concat(classNameToAdd).join(' '));
  },

  remove: function(classNameToRemove) {
    if (!this.include(classNameToRemove)) return;
    this.set(this.select(function(className) {
      return className != classNameToRemove;
    }).join(' '));
  },

  toString: function() {
    return this.toArray().join(' ');
  }
}

Object.extend(Element.ClassNames.prototype, Enumerable);
var Selector = Class.create();
Selector.prototype = {
  initialize: function(expression) {
    this.params = {classNames: []};
    this.expression = expression.toString().strip();
    this.parseExpression();
    this.compileMatcher();
  },

  parseExpression: function() {
    function abort(message) { throw 'Parse error in selector: ' + message; }

    if (this.expression == '')  abort('empty expression');

    var params = this.params, expr = this.expression, match, modifier, clause, rest;
    while (match = expr.match(/^(.*)\[([a-z0-9_:-]+?)(?:([~\|!]?=)(?:"([^"]*)"|([^\]\s]*)))?\]$/i)) {
      params.attributes = params.attributes || [];
      params.attributes.push({name: match[2], operator: match[3], value: match[4] || match[5] || ''});
      expr = match[1];
    }

    if (expr == '*') return this.params.wildcard = true;

    while (match = expr.match(/^([^a-z0-9_-])?([a-z0-9_-]+)(.*)/i)) {
      modifier = match[1], clause = match[2], rest = match[3];
      switch (modifier) {
        case '#':       params.id = clause; break;
        case '.':       params.classNames.push(clause); break;
        case '':
        case undefined: params.tagName = clause.toUpperCase(); break;
        default:        abort(expr.inspect());
      }
      expr = rest;
    }

    if (expr.length > 0) abort(expr.inspect());
  },

  buildMatchExpression: function() {
    var params = this.params, conditions = [], clause;

    if (params.wildcard)
      conditions.push('true');
    if (clause = params.id)
      conditions.push('element.id == ' + clause.inspect());
    if (clause = params.tagName)
      conditions.push('element.tagName.toUpperCase() == ' + clause.inspect());
    if ((clause = params.classNames).length > 0)
      for (var i = 0; i < clause.length; i++)
        conditions.push('Element.hasClassName(element, ' + clause[i].inspect() + ')');
    if (clause = params.attributes) {
      clause.each(function(attribute) {
        var value = 'element.getAttribute(' + attribute.name.inspect() + ')';
        var splitValueBy = function(delimiter) {
          return value + ' && ' + value + '.split(' + delimiter.inspect() + ')';
        }

        switch (attribute.operator) {
          case '=':       conditions.push(value + ' == ' + attribute.value.inspect()); break;
          case '~=':      conditions.push(splitValueBy(' ') + '.include(' + attribute.value.inspect() + ')'); break;
          case '|=':      conditions.push(
                            splitValueBy('-') + '.first().toUpperCase() == ' + attribute.value.toUpperCase().inspect()
                          ); break;
          case '!=':      conditions.push(value + ' != ' + attribute.value.inspect()); break;
          case '':
          case undefined: conditions.push(value + ' != null'); break;
          default:        throw 'Unknown operator ' + attribute.operator + ' in selector';
        }
      });
    }

    return conditions.join(' && ');
  },

  compileMatcher: function() {
    this.match = new Function('element', 'if (!element.tagName) return false; \
      return ' + this.buildMatchExpression());
  },

  findElements: function(scope) {
    var element;

    if (element = $(this.params.id))
      if (this.match(element))
        if (!scope || Element.childOf(element, scope))
          return [element];

    scope = (scope || document).getElementsByTagName(this.params.tagName || '*');

    var results = [];
    for (var i = 0; i < scope.length; i++)
      if (this.match(element = scope[i]))
        results.push(Element.extend(element));

    return results;
  },

  toString: function() {
    return this.expression;
  }
}

function $$() {
  return $A(arguments).map(function(expression) {
    return expression.strip().split(/\s+/).inject([null], function(results, expr) {
      var selector = new Selector(expr);
      return results.map(selector.findElements.bind(selector)).flatten();
    });
  }).flatten();
}
var Field = {
  clear: function() {
    for (var i = 0; i < arguments.length; i++)
      $(arguments[i]).value = '';
  },

  focus: function(element) {
    $(element).focus();
  },

  present: function() {
    for (var i = 0; i < arguments.length; i++)
      if ($(arguments[i]).value == '') return false;
    return true;
  },

  select: function(element) {
    $(element).select();
  },

  activate: function(element) {
    element = $(element);
    element.focus();
    if (element.select)
      element.select();
  }
}

/*--------------------------------------------------------------------------*/

var Form = {
  serialize: function(form) {
    var elements = Form.getElements($(form));
    var queryComponents = new Array();

    for (var i = 0; i < elements.length; i++) {
      var queryComponent = Form.Element.serialize(elements[i]);
      if (queryComponent)
        queryComponents.push(queryComponent);
    }

    return queryComponents.join('&');
  },

  getElements: function(form) {
    form = $(form);
    var elements = new Array();

    for (tagName in Form.Element.Serializers) {
      var tagElements = form.getElementsByTagName(tagName);
      for (var j = 0; j < tagElements.length; j++)
        elements.push(tagElements[j]);
    }
    return elements;
  },

  getInputs: function(form, typeName, name) {
    form = $(form);
    var inputs = form.getElementsByTagName('input');

    if (!typeName && !name)
      return inputs;

    var matchingInputs = new Array();
    for (var i = 0; i < inputs.length; i++) {
      var input = inputs[i];
      if ((typeName && input.type != typeName) ||
          (name && input.name != name))
        continue;
      matchingInputs.push(input);
    }

    return matchingInputs;
  },

  disable: function(form) {
    var elements = Form.getElements(form);
    for (var i = 0; i < elements.length; i++) {
      var element = elements[i];
      element.blur();
      element.disabled = 'true';
    }
  },

  enable: function(form) {
    var elements = Form.getElements(form);
    for (var i = 0; i < elements.length; i++) {
      var element = elements[i];
      element.disabled = '';
    }
  },

  findFirstElement: function(form) {
    return Form.getElements(form).find(function(element) {
      return element.type != 'hidden' && !element.disabled &&
        ['input', 'select', 'textarea'].include(element.tagName.toLowerCase());
    });
  },

  focusFirstElement: function(form) {
    Field.activate(Form.findFirstElement(form));
  },

  reset: function(form) {
    $(form).reset();
  }
}

Form.Element = {
  serialize: function(element) {
    element = $(element);
    var method = element.tagName.toLowerCase();
    var parameter = Form.Element.Serializers[method](element);

    if (parameter) {
      var key = encodeURIComponent(parameter[0]);
      if (key.length == 0) return;

      if (parameter[1].constructor != Array)
        parameter[1] = [parameter[1]];

      return parameter[1].map(function(value) {
        return key + '=' + encodeURIComponent(value);
      }).join('&');
    }
  },

  getValue: function(element) {
    element = $(element);
    var method = element.tagName.toLowerCase();
    var parameter = Form.Element.Serializers[method](element);

    if (parameter)
      return parameter[1];
  }
}

Form.Element.Serializers = {
  input: function(element) {
    switch (element.type.toLowerCase()) {
      case 'submit':
      case 'hidden':
      case 'password':
      case 'text':
        return Form.Element.Serializers.textarea(element);
      case 'checkbox':
      case 'radio':
        return Form.Element.Serializers.inputSelector(element);
    }
    return false;
  },

  inputSelector: function(element) {
    if (element.checked)
      return [element.name, element.value];
  },

  textarea: function(element) {
    return [element.name, element.value];
  },

  select: function(element) {
    return Form.Element.Serializers[element.type == 'select-one' ?
      'selectOne' : 'selectMany'](element);
  },

  selectOne: function(element) {
    var value = '', opt, index = element.selectedIndex;
    if (index >= 0) {
      opt = element.options[index];
      value = opt.value;
      if (!value && !('value' in opt))
        value = opt.text;
    }
    return [element.name, value];
  },

  selectMany: function(element) {
    var value = new Array();
    for (var i = 0; i < element.length; i++) {
      var opt = element.options[i];
      if (opt.selected) {
        var optValue = opt.value;
        if (!optValue && !('value' in opt))
          optValue = opt.text;
        value.push(optValue);
      }
    }
    return [element.name, value];
  }
}

/*--------------------------------------------------------------------------*/

var $F = Form.Element.getValue;

/*--------------------------------------------------------------------------*/

Abstract.TimedObserver = function() {}
Abstract.TimedObserver.prototype = {
  initialize: function(element, frequency, callback) {
    this.frequency = frequency;
    this.element   = $(element);
    this.callback  = callback;

    this.lastValue = this.getValue();
    this.registerCallback();
  },

  registerCallback: function() {
    setInterval(this.onTimerEvent.bind(this), this.frequency * 1000);
  },

  onTimerEvent: function() {
    var value = this.getValue();
    if (this.lastValue != value) {
      this.callback(this.element, value);
      this.lastValue = value;
    }
  }
}

Form.Element.Observer = Class.create();
Form.Element.Observer.prototype = Object.extend(new Abstract.TimedObserver(), {
  getValue: function() {
    return Form.Element.getValue(this.element);
  }
});

Form.Observer = Class.create();
Form.Observer.prototype = Object.extend(new Abstract.TimedObserver(), {
  getValue: function() {
    return Form.serialize(this.element);
  }
});

/*--------------------------------------------------------------------------*/

Abstract.EventObserver = function() {}
Abstract.EventObserver.prototype = {
  initialize: function(element, callback) {
    this.element  = $(element);
    this.callback = callback;

    this.lastValue = this.getValue();
    if (this.element.tagName.toLowerCase() == 'form')
      this.registerFormCallbacks();
    else
      this.registerCallback(this.element);
  },

  onElementEvent: function() {
    var value = this.getValue();
    if (this.lastValue != value) {
      this.callback(this.element, value);
      this.lastValue = value;
    }
  },

  registerFormCallbacks: function() {
    var elements = Form.getElements(this.element);
    for (var i = 0; i < elements.length; i++)
      this.registerCallback(elements[i]);
  },

  registerCallback: function(element) {
    if (element.type) {
      switch (element.type.toLowerCase()) {
        case 'checkbox':
        case 'radio':
          Event.observe(element, 'click', this.onElementEvent.bind(this));
          break;
        case 'password':
        case 'text':
        case 'textarea':
        case 'select-one':
        case 'select-multiple':
          Event.observe(element, 'change', this.onElementEvent.bind(this));
          break;
      }
    }
  }
}

Form.Element.EventObserver = Class.create();
Form.Element.EventObserver.prototype = Object.extend(new Abstract.EventObserver(), {
  getValue: function() {
    return Form.Element.getValue(this.element);
  }
});

Form.EventObserver = Class.create();
Form.EventObserver.prototype = Object.extend(new Abstract.EventObserver(), {
  getValue: function() {
    return Form.serialize(this.element);
  }
});
if (!window.Event) {
  var Event = new Object();
}

Object.extend(Event, {
  KEY_BACKSPACE: 8,
  KEY_TAB:       9,
  KEY_RETURN:   13,
  KEY_ESC:      27,
  KEY_LEFT:     37,
  KEY_UP:       38,
  KEY_RIGHT:    39,
  KEY_DOWN:     40,
  KEY_DELETE:   46,

  element: function(event) {
    return event.target || event.srcElement;
  },

  isLeftClick: function(event) {
    return (((event.which) && (event.which == 1)) ||
            ((event.button) && (event.button == 1)));
  },

  pointerX: function(event) {
    return event.pageX || (event.clientX +
      (document.documentElement.scrollLeft || document.body.scrollLeft));
  },

  pointerY: function(event) {
    return event.pageY || (event.clientY +
      (document.documentElement.scrollTop || document.body.scrollTop));
  },

  stop: function(event) {
    if (event.preventDefault) {
      event.preventDefault();
      event.stopPropagation();
    } else {
      event.returnValue = false;
      event.cancelBubble = true;
    }
  },

  // find the first node with the given tagName, starting from the
  // node the event was triggered on; traverses the DOM upwards
  findElement: function(event, tagName) {
    var element = Event.element(event);
    while (element.parentNode && (!element.tagName ||
        (element.tagName.toUpperCase() != tagName.toUpperCase())))
      element = element.parentNode;
    return element;
  },

  observers: false,

  _observeAndCache: function(element, name, observer, useCapture) {
    if (!this.observers) this.observers = [];
    if (element.addEventListener) {
      this.observers.push([element, name, observer, useCapture]);
      element.addEventListener(name, observer, useCapture);
    } else if (element.attachEvent) {
      this.observers.push([element, name, observer, useCapture]);
      element.attachEvent('on' + name, observer);
    }
  },

  unloadCache: function() {
    if (!Event.observers) return;
    for (var i = 0; i < Event.observers.length; i++) {
      Event.stopObserving.apply(this, Event.observers[i]);
      Event.observers[i][0] = null;
    }
    Event.observers = false;
  },

  observe: function(element, name, observer, useCapture) {
    var element = $(element);
    useCapture = useCapture || false;

    if (name == 'keypress' &&
        (navigator.appVersion.match(/Konqueror|Safari|KHTML/)
        || element.attachEvent))
      name = 'keydown';

    this._observeAndCache(element, name, observer, useCapture);
  },

  stopObserving: function(element, name, observer, useCapture) {
    var element = $(element);
    useCapture = useCapture || false;

    if (name == 'keypress' &&
        (navigator.appVersion.match(/Konqueror|Safari|KHTML/)
        || element.detachEvent))
      name = 'keydown';

    if (element.removeEventListener) {
      element.removeEventListener(name, observer, useCapture);
    } else if (element.detachEvent) {
      element.detachEvent('on' + name, observer);
    }
  }
});

/* prevent memory leaks in IE */
Event.observe(window, 'unload', Event.unloadCache, false);
var Position = {
  // set to true if needed, warning: firefox performance problems
  // NOT neeeded for page scrolling, only if draggable contained in
  // scrollable elements
  includeScrollOffsets: false,

  // must be called before calling withinIncludingScrolloffset, every time the
  // page is scrolled
  prepare: function() {
    this.deltaX =  window.pageXOffset
                || document.documentElement.scrollLeft
                || document.body.scrollLeft
                || 0;
    this.deltaY =  window.pageYOffset
                || document.documentElement.scrollTop
                || document.body.scrollTop
                || 0;
  },

  realOffset: function(element) {
    var valueT = 0, valueL = 0;
    do {
      valueT += element.scrollTop  || 0;
      valueL += element.scrollLeft || 0;
      element = element.parentNode;
    } while (element);
    return [valueL, valueT];
  },

  cumulativeOffset: function(element) {
    var valueT = 0, valueL = 0;
    do {
      valueT += element.offsetTop  || 0;
      valueL += element.offsetLeft || 0;
      element = element.offsetParent;
    } while (element);
    return [valueL, valueT];
  },

  positionedOffset: function(element) {
    var valueT = 0, valueL = 0;
    do {
      valueT += element.offsetTop  || 0;
      valueL += element.offsetLeft || 0;
      element = element.offsetParent;
      if (element) {
        p = Element.getStyle(element, 'position');
        if (p == 'relative' || p == 'absolute') break;
      }
    } while (element);
    return [valueL, valueT];
  },

  offsetParent: function(element) {
    if (element.offsetParent) return element.offsetParent;
    if (element == document.body) return element;

    while ((element = element.parentNode) && element != document.body)
      if (Element.getStyle(element, 'position') != 'static')
        return element;

    return document.body;
  },

  // caches x/y coordinate pair to use with overlap
  within: function(element, x, y) {
    if (this.includeScrollOffsets)
      return this.withinIncludingScrolloffsets(element, x, y);
    this.xcomp = x;
    this.ycomp = y;
    this.offset = this.cumulativeOffset(element);

    return (y >= this.offset[1] &&
            y <  this.offset[1] + element.offsetHeight &&
            x >= this.offset[0] &&
            x <  this.offset[0] + element.offsetWidth);
  },

  withinIncludingScrolloffsets: function(element, x, y) {
    var offsetcache = this.realOffset(element);

    this.xcomp = x + offsetcache[0] - this.deltaX;
    this.ycomp = y + offsetcache[1] - this.deltaY;
    this.offset = this.cumulativeOffset(element);

    return (this.ycomp >= this.offset[1] &&
            this.ycomp <  this.offset[1] + element.offsetHeight &&
            this.xcomp >= this.offset[0] &&
            this.xcomp <  this.offset[0] + element.offsetWidth);
  },

  // within must be called directly before
  overlap: function(mode, element) {
    if (!mode) return 0;
    if (mode == 'vertical')
      return ((this.offset[1] + element.offsetHeight) - this.ycomp) /
        element.offsetHeight;
    if (mode == 'horizontal')
      return ((this.offset[0] + element.offsetWidth) - this.xcomp) /
        element.offsetWidth;
  },

  clone: function(source, target) {
    source = $(source);
    target = $(target);
    target.style.position = 'absolute';
    var offsets = this.cumulativeOffset(source);
    target.style.top    = offsets[1] + 'px';
    target.style.left   = offsets[0] + 'px';
    target.style.width  = source.offsetWidth + 'px';
    target.style.height = source.offsetHeight + 'px';
  },

  page: function(forElement) {
    var valueT = 0, valueL = 0;

    var element = forElement;
    do {
      valueT += element.offsetTop  || 0;
      valueL += element.offsetLeft || 0;

      // Safari fix
      if (element.offsetParent==document.body)
        if (Element.getStyle(element,'position')=='absolute') break;

    } while (element = element.offsetParent);

    element = forElement;
    do {
      valueT -= element.scrollTop  || 0;
      valueL -= element.scrollLeft || 0;
    } while (element = element.parentNode);

    return [valueL, valueT];
  },

  clone: function(source, target) {
    var options = Object.extend({
      setLeft:    true,
      setTop:     true,
      setWidth:   true,
      setHeight:  true,
      offsetTop:  0,
      offsetLeft: 0
    }, arguments[2] || {})

    // find page position of source
    source = $(source);
    var p = Position.page(source);

    // find coordinate system to use
    target = $(target);
    var delta = [0, 0];
    var parent = null;
    // delta [0,0] will do fine with position: fixed elements,
    // position:absolute needs offsetParent deltas
    if (Element.getStyle(target,'position') == 'absolute') {
      parent = Position.offsetParent(target);
      delta = Position.page(parent);
    }

    // correct by body offsets (fixes Safari)
    if (parent == document.body) {
      delta[0] -= document.body.offsetLeft;
      delta[1] -= document.body.offsetTop;
    }

    // set position
    if(options.setLeft)   target.style.left  = (p[0] - delta[0] + options.offsetLeft) + 'px';
    if(options.setTop)    target.style.top   = (p[1] - delta[1] + options.offsetTop) + 'px';
    if(options.setWidth)  target.style.width = source.offsetWidth + 'px';
    if(options.setHeight) target.style.height = source.offsetHeight + 'px';
  },

  absolutize: function(element) {
    element = $(element);
    if (element.style.position == 'absolute') return;
    Position.prepare();

    var offsets = Position.positionedOffset(element);
    var top     = offsets[1];
    var left    = offsets[0];
    var width   = element.clientWidth;
    var height  = element.clientHeight;

    element._originalLeft   = left - parseFloat(element.style.left  || 0);
    element._originalTop    = top  - parseFloat(element.style.top || 0);
    element._originalWidth  = element.style.width;
    element._originalHeight = element.style.height;

    element.style.position = 'absolute';
    element.style.top    = top + 'px';;
    element.style.left   = left + 'px';;
    element.style.width  = width + 'px';;
    element.style.height = height + 'px';;
  },

  relativize: function(element) {
    element = $(element);
    if (element.style.position == 'relative') return;
    Position.prepare();

    element.style.position = 'relative';
    var top  = parseFloat(element.style.top  || 0) - (element._originalTop || 0);
    var left = parseFloat(element.style.left || 0) - (element._originalLeft || 0);

    element.style.top    = top + 'px';
    element.style.left   = left + 'px';
    element.style.height = element._originalHeight;
    element.style.width  = element._originalWidth;
  }
}

// Safari returns margins on body which is incorrect if the child is absolutely
// positioned.  For performance reasons, redefine Position.cumulativeOffset for
// KHTML/WebKit only.
if (/Konqueror|Safari|KHTML/.test(navigator.userAgent)) {
  Position.cumulativeOffset = function(element) {
    var valueT = 0, valueL = 0;
    do {
      valueT += element.offsetTop  || 0;
      valueL += element.offsetLeft || 0;
      if (element.offsetParent == document.body)
        if (Element.getStyle(element, 'position') == 'absolute') break;

      element = element.offsetParent;
    } while (element);

    return [valueL, valueT];
  }
}

/*
* @加载页面时在状态栏显示执行时间
* @by yesun
*/
var s = 0;
var timeout;
function StatusTime(){
    s++;
    window.status = "正在执行中...耗时" + s +"秒！";
    timeout = setTimeout("StatusTime();", 1000);
    function Close(){
        window.status = "执行完毕，耗时" + s +"秒！";
        clearTimeout(timeout);
        return;
    }
    this.Close = Close;
}


/*
 * @加载页面时显示进度条
 * @by seaman
 */
function ProgressBar(){	

    var top = (document.documentElement.scrollTop*2+document.body.clientHeight+120)/3;
    var left = (document.body.clientWidth-320)/2;
	
	this.divCover = document.createElement("div");
	this.divCover.id = "__divCover";
	this.divCover.style.cssText = "position:absolute;top:0px;left:0px;width:" + document.body.clientWidth+ "px; height:" + document.body.clientHeight + "px;background-color:#ffffff;opacity:0.1;filter:alpha(opacity=10);"
	this.divCover.style.display="none";	
	document.body.appendChild(this.divCover);

    //event.clientY 可以使用这个来取得当前点击的位置

    this.divProcesserBar = document.createElement("div");
    this.divProcesserBar.id = "__divProcesserBar";
   
    this.divProcesserBar.style.cssText = "z-index:100;text-align:center;position:absolute; top:"+top+"px; left:"+left+"px; width:300px; height:90px;background-color:#f2f2f2;border:1px #84AE5A solid;padding:10px;opacity:0.9;filter:alpha(opacity=90);";
    this.divProcesserBar.innerHTML = "<span id=\"__processerBarText\" style=\"color:#000;font-weight:bolder;\"></span>";
    this.divProcesserBar.style.display="none";
    this.divXX = document.createElement("div");
    this.divXX.id = "__divXX";
    this.divXX.style.cssText = "text-align:center;position:absolute; top:"+top+"px; left:"+left+"px; width:300px; height:90px;filter:alpha(opacity=90);";
	this.divXX.innerHTML = "<iframe \"width=320\" \"height=110\" id=\"__myiframe\" style=\"border:0px;background-color:#fff;opacity:0;filter:alpha(opacity=0);\"/>";
    
	
	
	
    document.body.appendChild(this.divXX); 
    document.body.appendChild(this.divProcesserBar);

          function SetStatus(text){
                  this.text = text;
                  this.Show();
          }

          function Show(){

                  if(this.isNeedProgressBar)
                  {
                          this.divProcesserBar.childNodes.item(0).innerHTML = this.text + "<br/><img src=\"images/loading.gif\"/>";
                          if(!this.isNeedConfirmButton)
                          {
                            this.divProcesserBar.childNodes.item(0).innerHTML = "<br/>" + this.divProcesserBar.childNodes.item(0).innerHTML;
                          }
                  }
                  else
                  {
                          this.divProcesserBar.childNodes.item(0).innerHTML = this.text;
                  }


                  var htmlText = this.divProcesserBar.childNodes.item(0).innerHTML;
                  if(this.isNeedConfirmButton){
                        htmlText += "<br/><br/><button style=\"height:24px;\" onclick=\"javascript:document.body.removeChild(document.getElementById('__divXX'));document.body.removeChild(document.getElementById('__divCover'));document.body.removeChild(document.getElementById('__divProcesserBar'));";
                        if(this.focusItem!="")
                        {
                          htmlText += "$('" + this.focusItem + "').focus();";
                        }
                        htmlText += "\" >   确 认   </button>"
                  }
                  this.divProcesserBar.childNodes.item(0).innerHTML = htmlText;

                  this.divProcesserBar.style.display="block";
                  this.divXX.style.display="block";
         	  this.divCover.style.display="block";
		  //this.divProcesserBar.focus();
          }

          function Close()
          {
			try{
	            document.body.removeChild(this.divCover);
		        document.body.removeChild(this.divProcesserBar);
		        document.body.removeChild(this.divXX);
			} catch (e) {}
          }

          function Top(top)
          {
            this.divProcesserBar.style.top = top;
            this.divXX.style.top = top;
          }


          function getText()
          {
                  return this.text;
          }

          this.text = "";
          this.SetStatus = SetStatus;
          this.Show = Show;
          this.Close = Close;
          this.getText = getText;
  }
  ProgressBar.prototype.isNeedConfirmButton = false;
  ProgressBar.prototype.isNeedProgressBar = false;
  ProgressBar.prototype.focusItem = "";
  
  
  
  /*
  * 功能：常用方法
  */
  //是否为电子邮件
	function IsEmail(s)
	{
		var reg = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
		if(reg.test(s))
			return true;
		else
			return false;
	}
	
	//验证电话号码，只允许数字和“-”
	function IsTel(s)
	{
		var reg = /[\d|-]{7,15}/;
		if(reg.test(s))
			return true;
		else
			return false;
	}
	
	
	//去除首尾空格
	function Trim(s) {return s.replace(/(^\s+)|(\s+$)/g, "");}
	//去除全部空格	
	function TrimAll(s) {return s.replace(/\s+/g, "");}
	//去除“'”	
	function SafeInput(s) {return Trim(s.replace(/('+)/g,'’'));}	
	//转换非法字符for Xml
	function SafeXML(s) {
		s = s.replace(/(&+)/g,'&amp;');
		s = s.replace(/(>+)/g,'&gt;');
		s = s.replace(/(<+)/g,'&lt;');
		s = s.replace(/("+)/g,'&quot;');
		s = s.replace(/('+)/g,'&apos;');
		return s;
	}
	//转换非法字符for Xml
	function SafeXMLSBCcase(s) {
		s = s.replace(/(>+)/g,'＞');
		s = s.replace(/(<+)/g,'＜');
		s = s.replace(/("+)/g,'＂');
		s = s.replace(/('+)/g,'＇');
		s = s.replace(/(&+)/g,'＆');
		return s;
	}
	//Html Encode
	function HTMLEncode(s) {
		s = s.replace(/(\s+)/g,'&nbsp;');
		s = s.replace(/(\n+)/g,'<br/>');
		return s;
	}	
	//去除“&”
	function SafeURL(s) {
		return Trim(s.replace(/(&+)/g,''));
	}
	//去除所有不安全字符
	function SafeAll(s) {return SafeXML(SafeURL(s));}
	
	//验证身份证号码
	function IsIdno(s){
		if (s==""){	return confirm("没有填写身份证号，这样将无法判定其生日！\n确定继续吗？");}
		if (s.length != 15 & s.length != 18){
			alert("请填入正确的身份证号码");
			return false;
		}
		if (IsNumber(s.substring(0,17))){
			alert("请填入正确的身份证号码");
			return false;
	    }
		if (IsNumber(s.substring(17,18)) & s.substring(17,18) != "x" & s.substring(17,18) != "X"){
			alert("请填入正确的身份证号码");
			return false;
		}
		return true;
	}
	//含有非数字字符 返回 true
	function IsNumber(s){ //适于校验非负整数
	   var reg = /^[01233456789]{1,}$/;
		if(reg.test(s))
			return true;
		else
			return false;
	}
	
	//从身份证号里面得到日期
	function getBirthdayFromIdno(IDno){
		var sBirthday;
		if(IDno.length==15){
			sBirthday = "19" + IDno.substring(6,8);
			sBirthday = sBirthday + "-" + IDno.substring(8,10);
			sBirthday = sBirthday + "-" + IDno.substring(10,12);
		}
		if(IDno.length==18){
			sBirthday = IDno.substring(6,10);
			sBirthday = sBirthday + "-" + IDno.substring(10,12);
			sBirthday = sBirthday + "-" + IDno.substring(12,14);
		}
		return sBirthday;
	}
	
	//判断日期是否合法
	//参数g_dateVal格式："1980-01-01"
	function IsDate(g_dateVal){ 
		var s = g_dateVal.replace(/-/g,"/"); 
		var newdate=new Date(s); 
		var s = newdate.getYear();
		return isNAN(s);
	} 
	//判断是否位数字
	function checkObjIsNumber(objtxt,izero){
		var chname;
		if (typeof(objtxt.chname)=="undefined"){
			chname = "对象";
		}
		else{
			chname = Trim(objtxt.chname)
			if (chname==""){chname = "对象";}
		}
		
		objtxt.value=Trim(objtxt.value);
		if (isNaN(parseFloat(objtxt.value))){
			alert(chname + "不是有效数字！");
			objtxt.focus();return false;
		}
		objtxt.value=parseFloat(objtxt.value)
		if (izero>0){
			if(!(parseFloat(objtxt.value)>0)){
				alert(chname + "需大于零！");
				objtxt.focus();return false;
			}
		}
		else if (izero>=0){
			if(!(parseFloat(objtxt.value)>=0)){
				alert(chname + "需大于等于零！");
				objtxt.focus();return false;
			}
		}
		return true;
	}
	//取得单选框值
	function getRadioValue(objOpt){
		for (var i=0;i<objOpt.length;i++){
			if (objOpt[i].checked) return objOpt[i].value
		}
	}
  
  
  
  /*
 * @验证输入框
 * @Modify by yesun
 * @input 具有下面属性 notempty,istel,isemail,isnumber,chname
 */
 function CheckForm()
 {
	//定义
	this.Trim = Trim;
	this.TrimAll = TrimAll;
	this.SafeInput = SafeInput;
	this.SafeXML = SafeXML;
	this.SafeXMLSBCcase = SafeXMLSBCcase;
	this.SafeURL = SafeURL;
	this.SafeAll = SafeAll;
	this.HTMLEncode = HTMLEncode;	
	this.IsTel = IsTel;
	this.IsIdno = IsIdno;
	this.IsNumber = IsNumber;
	this.getBirthdayFromIdno = getBirthdayFromIdno;
	this.IsDate = IsDate;
	this.checkObjIsNumber = checkObjIsNumber;
	this.getRadioValue = getRadioValue;
	this.checkForm = checkForm;
	this.IsEmail = IsEmail;
	
	//是否为电子邮件
	function IsEmail(s)
	{
		var reg = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
		if(reg.test(s))
			return true;
		else
			return false;
	}
	
	//验证电话号码，只允许数字和“-”
	function IsTel(s)
	{
		var reg = /[\d|-]{7,15}/;
		if(reg.test(s))
			return true;
		else
			return false;
	}
	
	
	//去除首尾空格
	function Trim(s) {return s.replace(/(^\s+)|(\s+$)/g, "");}
	//去除全部空格	
	function TrimAll(s) {return s.replace(/\s+/g, "");}
	//去除“'”	
	function SafeInput(s) {return Trim(s.replace(/('+)/g,'’'));}	
	//转换非法字符for Xml
	function SafeXML(s) {
		s = s.replace(/(&+)/g,'&amp;');
		s = s.replace(/(>+)/g,'&gt;');
		s = s.replace(/(<+)/g,'&lt;');
		s = s.replace(/("+)/g,'&quot;');
		s = s.replace(/('+)/g,'&apos;');
		return s;
	}
	//转换非法字符for Xml
	function SafeXMLSBCcase(s) {
		s = s.replace(/(>+)/g,'＞');
		s = s.replace(/(<+)/g,'＜');
		s = s.replace(/("+)/g,'＂');
		s = s.replace(/('+)/g,'＇');
		s = s.replace(/(&+)/g,'＆');
		return s;
	}
	//Html Encode
	function HTMLEncode(s) {
		s = s.replace(/(\s+)/g,'&nbsp;');
		s = s.replace(/(\n+)/g,'<br/>');
		return s;
	}	
	//去除“&”
	function SafeURL(s) {
		return Trim(s.replace(/(&+)/g,''));
	}
	//去除所有不安全字符
	function SafeAll(s) {return SafeXML(SafeURL(s));}
	
	//验证身份证号码
	function IsIdno(s){
		if (s==""){	return confirm("没有填写身份证号，这样将无法判定其生日！\n确定继续吗？");}
		if (s.length != 15 & s.length != 18){
			alert("请填入正确的身份证号码");
			return false;
		}
		if (IsNumber(s.substring(0,17))){
			alert("请填入正确的身份证号码");
			return false;
	    }
		if (IsNumber(s.substring(17,18)) & s.substring(17,18) != "x" & s.substring(17,18) != "X"){
			alert("请填入正确的身份证号码");
			return false;
		}
		return true;
	}
	//含有非数字字符 返回 true
	function IsNumber(s){ //适于校验非负整数
	   var reg = /^[01233456789]{1,}$/;
		if(reg.test(s))
			return true;
		else
			return false;
	}
	
	//从身份证号里面得到日期
	function getBirthdayFromIdno(IDno){
		var sBirthday;
		if(IDno.length==15){
			sBirthday = "19" + IDno.substring(6,8);
			sBirthday = sBirthday + "-" + IDno.substring(8,10);
			sBirthday = sBirthday + "-" + IDno.substring(10,12);
		}
		if(IDno.length==18){
			sBirthday = IDno.substring(6,10);
			sBirthday = sBirthday + "-" + IDno.substring(10,12);
			sBirthday = sBirthday + "-" + IDno.substring(12,14);
		}
		return sBirthday;
	}
	
	//判断日期是否合法
	//参数g_dateVal格式："1980-01-01"
	function IsDate(g_dateVal){ 
		var s = g_dateVal.replace(/-/g,"/"); 
		var newdate=new Date(s); 
		var s = newdate.getYear();
		return isNAN(s);
	} 
	//判断是否位数字
	function checkObjIsNumber(objtxt,izero){
		var chname;
		if (typeof(objtxt.chname)=="undefined"){
			chname = "对象";
		}
		else{
			chname = Trim(objtxt.chname)
			if (chname==""){chname = "对象";}
		}
		
		objtxt.value=Trim(objtxt.value);
		if (isNaN(parseFloat(objtxt.value))){
			alert(chname + "不是有效数字！");
			objtxt.focus();return false;
		}
		objtxt.value=parseFloat(objtxt.value)
		if (izero>0){
			if(!(parseFloat(objtxt.value)>0)){
				alert(chname + "需大于零！");
				objtxt.focus();return false;
			}
		}
		else if (izero>=0){
			if(!(parseFloat(objtxt.value)>=0)){
				alert(chname + "需大于等于零！");
				objtxt.focus();return false;
			}
		}
		return true;
	}
	//取得单选框值
	function getRadioValue(objOpt){
		for (var i=0;i<objOpt.length;i++){
			if (objOpt[i].checked) return objOpt[i].value
		}
	}
	
	
	/*----------------------------------------------------------
        功能：验证某个form或者div里面的控件是否合法 , 下面的控件只允许在IE下运行
    -----------------------------------------------------------*/
	function checkForm(formname){
		/*
		formname要求格式为"form"+业务英文名称
		txt格式为:name格式为"txt"+输入域英文名称 ; chname格式为输入域中文名称
		*/
		if( formname == null || formname == "" || typeof(formname) == "undefined" )
		{
			alert("对不起,formname参数错误");
			return;
		}
		var _progressBar = new ProgressBar();
		with (formname){
			var elements = Form.getElements(formname);
			var len = elements.length;
			for(var i=0; i<len; i++){
				if (elements[i].type=="text"||elements[i].type=="password"||elements[i].tagName=="textarea"){
					elements[i].value=Trim(elements[i].value);

					//不能为空
		            alert(elements[i].value);
		            alert(elements[i].notempty);
					if ((elements[i].value=="")&&(elements[i].notempty=="true")){
						_progressBar.isNeedConfirmButton = true;
					    _progressBar.focusItem = elements[i].id;
					    _progressBar.SetStatus("<img src='../images/error.gif' align='absmiddle'> 对不起,请填写" + (typeof(elements[i].chname)=="undefined"?"该对象":elements[i].chname) + "！");
					    return false;
					}
					//电话
					if( elements[i].notempty=="true" )
					{
						//不能为空，并且判断tel
						if ((elements[i].istel=="true") && !IsTel(elements[i].value) ){
							_progressBar.isNeedConfirmButton = true;
						    _progressBar.focusItem = elements[i].id;
						    _progressBar.SetStatus("<img src='../images/error.gif' align='absmiddle'> 对不起," + (typeof(elements[i].chname)=="undefined"?"该对象":elements[i].chname) + "格式不正确！");
						    return false;
						}
					}
					else
					{
						//可以为空，但是如果有内容就需要判断
						if (elements[i].value!="" && (elements[i].istel=="true") && !IsTel(elements[i].value) ){
							_progressBar.isNeedConfirmButton = true;
						    _progressBar.focusItem = elements[i].id;
						    _progressBar.SetStatus("<img src='../images/error.gif' align='absmiddle'> 对不起," + (typeof(elements[i].chname)=="undefined"?"该对象":elements[i].chname) + "格式不正确！");
						    return false;
						}
					}
					//邮件
					if( elements[i].notempty=="true" )
					{
						//不能为空，并且判断email
						if ((elements[i].isemail=="true") && !IsEmail(elements[i].value)){
						_progressBar.isNeedConfirmButton = true;
					    _progressBar.focusItem = elements[i].id;
					    _progressBar.SetStatus("<img src='../images/error.gif' align='absmiddle'> 对不起," + (typeof(elements[i].chname)=="undefined"?"该对象":elements[i].chname) + "格式不正确！");
					    return false;
						}
					}
					else
					{
						//可以为空，但是如果有内容就需要判断
						if (elements[i].value != "" && (elements[i].isemail=="true") && !IsEmail(elements[i].value)){
						_progressBar.isNeedConfirmButton = true;
					    _progressBar.focusItem = elements[i].id;
					    _progressBar.SetStatus("<img src='../images/error.gif' align='absmiddle'> 对不起," + (typeof(elements[i].chname)=="undefined"?"该对象":elements[i].chname) + "格式不正确！");
					    return false;
						}
					}					
					//数字
					if( elements[i].notempty=="true" )
					{
						if ((elements[i].isnumber=="true") && !IsNumber(elements[i].value)){
							_progressBar.isNeedConfirmButton = true;
						    _progressBar.focusItem = elements[i].id;
						    _progressBar.SetStatus("<img src='../images/error.gif' align='absmiddle'> 对不起," + (typeof(elements[i].chname)=="undefined"?"该对象":elements[i].chname) + "必须为数字！");
						    return false;
						}
					}
					else
					{
						if (elements[i].value != "" && (elements[i].isnumber=="true") && !IsNumber(elements[i].value)){
							_progressBar.isNeedConfirmButton = true;
						    _progressBar.focusItem = elements[i].id;
						    _progressBar.SetStatus("<img src='../images/error.gif' align='absmiddle'> 对不起," + (typeof(elements[i].chname)=="undefined"?"该对象":elements[i].chname) + "必须为数字！");
						    return false;
						}
					}
				}
				else if (elements[i].tagName=="SELECT"){
					if(elements[i].value==""){
						//alert("请选择" + elements[i].chname + "！");
						_progressBar.isNeedConfirmButton = true;
					    _progressBar.focusItem = elements[i].id;
					    _progressBar.SetStatus("<img src='../images/error.gif' align='absmiddle'> 对不起，请选择" + (typeof(elements[i].chname)=="undefined"?"该对象":elements[i].chname) + "！");
					    return false;
					}
				}
				else if (elements[i].tagName=="INPUT"&&elements[i].type=="radio"){
					//radio需默认有选择
					if(elements[i].notempty == "true")
					{
						var radios = document.getElementsByName(elements[i].name);					
						var radioValue = "";
						for(var j=0 ;j<radios.length;j++)
						{
							if(radios[j].checked)
							{
								radioValue = radios[j].value;
							}
						}
						if(radioValue == "")
						{
							_progressBar.isNeedConfirmButton = true;
						    _progressBar.focusItem = elements[i].id;
						    _progressBar.SetStatus("<img src='../images/error.gif' align='absmiddle'> 对不起，请选择" + (typeof(elements[i].chname)=="undefined"?"该对象":elements[i].chname) + "！");
						    return false;
						}
					}
				}				
			}
		}		
		_progressBar.Close();
		return true;
	}
}


/*----------------------------------------------------------
    功能：Debug Error 
-----------------------------------------------------------*/
function Debug(message)
{
    var newwin=window.open('','Debug','height=500, width=700,toolbar=0, menubar=0, scrollbars=1, resizable=1, location=0, status=0');
    newwin.opener = null // 防止代码对论谈页面修改
    //防止页面内容重复
    //if( typeof(newwin.document.body) != "undefined")
    //   newwin.document.body.innerHTML = "";    
    newwin.document.write("<html><body><h1>Debug</h1><br/>");
    newwin.document.write(message);
    newwin.document.write("<br/></body></html>");
    //置顶
    newwin.focus();    
}

/*----------------------------------------------------------
    功能：checkbox选择函数
        引用该函数的页面
        form的id必须为formlist
-----------------------------------------------------------*/
function selall(selflag){
    var formlist = document.getElementById('formlist');
	if(typeof(formlist)=="undefined"){alert("没有可选对象!");return false;}
	if(typeof(formlist.checkbox)=="undefined"){alert("没有可选对象!");return false;}
	var len=formlist.checkbox.length;
	if(typeof(len)=="undefined"){
		if(selflag==2){
			formlist.checkbox.checked=(!formlist.checkbox.checked)&&(!formlist.checkbox.disabled);
		}
		else{
			formlist.checkbox.checked=selflag&&(!formlist.checkbox.disabled);
		}
	}
	else{
		if(selflag==2){
			for (i=0;i<len;i++){
				formlist.checkbox[i].checked=(!formlist.checkbox[i].checked)&&(!formlist.checkbox[i].disabled);
			}
		}
		else{
			for (i=0;i<len;i++){
				formlist.checkbox[i].checked=selflag&&(!formlist.checkbox[i].disabled);
			}
		}
	}
}


/*----------------------------------------------------------
    功能：sign:value间除逗号外的分隔符
-----------------------------------------------------------*/
function sel(sign) {
  	m_ids="";
	m_idCount=0;
    var formlist = document.getElementById('formlist');
	if(typeof(formlist)=="undefined"){alert("没有可选对象!");return false;}
  	if(typeof(formlist.checkbox)=="undefined"){alert("没有可选对象!");return false;}
  	if(typeof(sign)=="undefined"){sign="";}
  	var sum=0,str="";
  	var len=formlist.checkbox.length;
	if(typeof(len)=="undefined"){
		if(formlist.checkbox.checked){
			str=sign + formlist.checkbox.value + sign + ","
			sum=1;
		}
		else{
			alert("没有选择对象!");return false;
		}
	}
	else{
		for (i=0;i<len;i++){
			if (formlist.checkbox[i].checked) 
			{
				str=str + sign + formlist.checkbox[i].value + sign + ",";
				sum=sum+1;
			}
		}
	}
	if (str==""){alert("没有选择对象!");return false;}
	str=str.substring(0,str.length-1);
	m_ids=str;
	m_idCount=sum;
	return true;
}

/*----------------------------------------------------------
    功能：取得Radio的值
-----------------------------------------------------------*/
function GetRadioValue(radioname)
{
    var radiolist = document.getElementsByName(radioname);
    for(var i = 0;i < radiolist.length;i++)
    {
        if( radiolist.item(i).checked == true )
            return radiolist.item(i).value;
    }
}

/*----------------------------------------------------------
    功能：设置Radio的默认值
-----------------------------------------------------------*/
function SetRadioValue(radioname,radiovalue)
{
    var radiolist = document.getElementsByName(radioname);
    for(var i = 0;i < radiolist.length;i++)
    {
        if(radiolist.item(i).value == radiovalue)
            radiolist.item(i).checked = true;
    }
}


/*----------------------------------------------------------
    功能：弹出窗口
-----------------------------------------------------------*/
function OpenWin(url,width,heigth)
{
}