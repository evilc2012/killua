var menuData = [
	                    [{
	                            text: "占用",
	                            func: function(){
	                                var id = $(this).attr("id");
	                                if(!!id){
	                                	sendReq(id, 2);
	                                }
	                            }
	                    }],
	                    [{
	                            text: "释放",
	                            func: function(){
	                                var id = $(this).attr("id");
	                                if(!!id){
	                                	sendReq(id, 1);
	                                }
	                            }
	                    }]
	                ];

		var stompClient = null;

		function connect() {
	        var socket = new SockJS('/machinesEndpoint');
	        stompClient = Stomp.over(socket);
	        stompClient.connect({}, function(frame) {
	            stompClient.subscribe('/topic/machines', function(respnose){
	                showResponse(JSON.parse(respnose.body));
	            });
	        });
	    }


	    function initStatus() {
	        $.ajax({
                 type: 'GET',
                 url: '/flushState',
                 success: function(result){
                    if(!!result){
                    console.log(result);
                        for(var p in result){
                            var obj = result[p];
                            $("#" + obj.id)[0].style.backgroundColor = 'green';
                            $("#" + obj.id)[0].innerHTML = obj.realname;
                        }
                    }
                 }
            });
	    }

	    function chooseColor(obj){
            var color = "";
        	switch(obj.type){
        	    case 2 : color = "green";	break;
        	}
        	return color;
        }

		function sendReq(id, type) {
	        stompClient.send("/occupy", {}, JSON.stringify({'id': id, 'type': type, "userId":$('#userId').val()}));
	    }

		function showResponse(obj){
		    var changeFont = false;
		    var fontColor = "green";
			if(obj.status == 200){
				document.getElementById(obj.id).style.backgroundColor = chooseColor(obj);
				changeFont = true;
			} else {
			    fontColor = "red";
			}
			if(changeFont){
                $("#" + obj.id)[0].innerHTML = obj.type == 1 ? "" : obj.occupant;
            }
			if(!!obj.rspMsg){
			    if(! ('Notification' in window) ){
                    $("#response").append('<font color="' + fontColor + '">' + obj.rspMsg + '</font><br/>');
                } else {
                    Notification.requestPermission(function(permission){
                        var notification = new Notification('通知', {body:obj.rspMsg, icon:'http://i2.zastatic.com/zhenai3/zhenai2015/img/myhome/logo_c269fa4.png', dir:'auto'});
                    });
                }
		    }
		}