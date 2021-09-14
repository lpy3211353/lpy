$(function(){
    $.ajax({
        "url":"check.do",
        "dataType":"JSON",
        "type":"POST",
        success:function (res){
            if (res.res==100){
                $("#lo").text(res.data.username)
                $("#lo").attr("href","userinfo.jsp")
                $("#username").text(res.data.username)
            }else{
                location.href="login.jsp"
            }
        }
    })

    $("#quit").click(function (){
        $.ajax({
            "url":"quit.do",
            "type":"POST",
            success:function (res){
                if (res.res==100){
                    location.href="login.jsp"
                }else{
                    location.href="login.jsp"
                }
            }
        })
    })

    $("#submit").click(function (){
        let oldpassword=$("#oldpassword").val()
        let newpassword=$("#newpassword").val()
        $.ajax({
            "url":"user.do",
            "type":"POST",
            "dataType":"JSON",
            "data":{oldpassword:oldpassword,newpassword:newpassword,type:1},
            success:function (res){
                if (res.res==100){
                    swal({
                        title:"提示",
                        type:"info",
                        text:res.text,
                        confirmButtonColor: "#3170a7"
                    },function(isConfirm){
                        $.ajax({
                            "url":"quit.do",
                            "type":"POST",
                            "async": false,
                            success:function (res){
                                location.href = "login.jsp"
                            }
                        })
                    })
                }else{
                    swal({
                        title:"提示",
                        type:"info",
                        text:res.text,
                        confirmButtonColor: "#3170a7"
                    })
                }
            }
        })
    })


});