$(document).ready(function() {
    $('#form2').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	'activity.activity_title': {
                validators: {
                    notEmpty: {
                        message: '活动标题不能为空'
                    },
                    stringLength: {
                        min: 0,
                        max: 100,
                        message: '不需要这么长!'
                    }
                }
            },
            'file': {
                validators: {
                    notEmpty: {
                        message: '活动图片不能为空'
                    }
                    
                }
            },
            'activity.activity_title': {
                validators: {
                    notEmpty: {
                        message: '活动标题不能为空'
                    },
                   
                }
            },
            'activity.activity_content': {
                validators: {
                    notEmpty: {
                        message: '活动内容不能为空'
                    },
                     
                }
            },
            
            'activity.activity_address': {
                validators: {
                    notEmpty: {
                        message: '活动地址不能为空'
                    },   
                   
                }
            },
            'activity.end_time': {
                validators: {
                    notEmpty: {
                        message: '结束时间不能为空'
                    },
                    
                }
            },          
           
            
            ages: {
                validators: {
                    lessThan: {
                        value: 100,
                        inclusive: true,
                        message: 'The ages has to be less than 100'
                    },
                    greaterThan: {
                        value: 10,
                        inclusive: false,
                        message: 'The ages has to be greater than or equals to 10'
                    }
                }
            }
        }
    });
});


$(document).ready(function() {
    $('#form1').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	'activity.activity_title': {
                validators: {
                    notEmpty: {
                        message: '活动标题不能为空'
                    },
                    stringLength: {
                        min: 0,
                        max: 100,
                        message: '不需要这么长!'
                    }
                }
            },
            
            'activity.activity_title': {
                validators: {
                    notEmpty: {
                        message: '活动标题不能为空'
                    },
                   
                }
            },
            'activity.activity_content': {
                validators: {
                    notEmpty: {
                        message: '活动内容不能为空'
                    },
                     
                }
            },
            
            'activity.activity_address': {
                validators: {
                    notEmpty: {
                        message: '活动地址不能为空'
                    },   
                   
                }
            },
            'activity.end_time': {
                validators: {
                    notEmpty: {
                        message: '结束时间不能为空'
                    },
                    
                }
            },          
           
            
            ages: {
                validators: {
                    lessThan: {
                        value: 100,
                        inclusive: true,
                        message: 'The ages has to be less than 100'
                    },
                    greaterThan: {
                        value: 10,
                        inclusive: false,
                        message: 'The ages has to be greater than or equals to 10'
                    }
                }
            }
        }
    });
});
