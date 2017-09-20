/**
 * 
 * @author Srikanth Subramanian
 * 
 * Jquery plugin for replacing lengthy names with ellipsis.
 * Also includes a tooltip functionality which shows the entire text.
 * 
 * created on 26 September, 2012.
 * 
 * **/

(function($) {
	
    $.fn.ellipsis = function(charCount) {
        return $(this).each(function() {
            var el = $(this);
            
            var originalText = el.html();
            var originalTextLength = originalText.length;
            
            var tempNode = $(this.cloneNode(true));
            
            var min = 0;
            var max = charCount;
            
            if(charCount < originalTextLength){
	            if (min<=max){
	            	var tooltipHTML = null;
	            	var trimLocation = (min + max);
	                var text = originalText.substr(0, trimLocation);
	                tempNode.html(text + "&hellip;");
                    
	                
	            } 
	            if (min > max) {
	            	//If the max value is greater than the min value, just raise a warning.
	            	console.log('character count has to be greater than 0.');
	            }
            }
            else {
            	return false;
            }
            el.html(tempNode.html());
            tempNode.remove();
            
            el.mouseenter(function(){
				el.parent().find('.ellipsis-tooltip').fadeIn(500);
			});
			
			el.mouseleave(function(){
				el.parent().find('.ellipsis-tooltip').fadeOut(500);
			});
        });
    };
})(jQuery); 