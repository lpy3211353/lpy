$(function(){
    $.ajax({
        "url":"check.do",
        "dataType":"JSON",
        "type":"POST",
        success:function (res){
            if (res.res==100){
                console.log(res.data)
                if (res.data.identify>1){
                    $("#delete").css("display","block")
                }
                $("#lo").text(res.data.username)
                $("#lo").attr("href","userinfo.jsp")
                $("#forthis").attr("placeholder","在此处输入")
            }
        }
    })

    $("#delete").click(function (){
        $.ajax({
            "url":"delete.do",
            "type":"POST",
            "dataType":"JSON",
            "data":{ID:GetQueryString("id")},
            success:function (res){
                swal({
                    title:"已成功",
                    type:"success",
                    text:"删除成功",
                    confirmButtonColor: "#2894FF"
                },function (isConfirm){
                    location.href = "search.jsp"
                })
            }
        })
    })

    $("#collect").click(function (){
        $.ajax({
            "url":"user.do",
            "type":"POST",
            "dataType":"JSON",
            "data":{ID:GetQueryString("id"),type:3},
            success:function (res){
                swal({
                    title:"成功",
                    type:"success",
                    text:"收藏成功",
                    confirmButtonColor: "#2894FF"
                },function (isConfirm){
                    location.href = "item.jsp?id="+GetQueryString("id")
                })
            }
        })
    })

    $("#zan").click(function (){
        $.ajax({
            "url":"zan.do",
            "type":"POST",
            "dataType":"JSON",
            "data":{ID:GetQueryString("id")},
            success:function (res){
                swal({
                    title:"成功",
                    type:"success",
                    text:"点赞成功",
                    confirmButtonColor: "#2894FF"
                })
            }
        })
    })

    $("#submit").click(function (){
        var msg=$("#forthis").val()
        $.ajax({
            "url":"comment.do",
            "type":"POST",
            "dataType":"JSON",
            "data":{ID:GetQueryString("id"),msg:msg},
            success:function (res){
                if (res.res==100){
                    if (msg==""){
                        swal({
                            title:"错误",
                            type:"warning",
                            text:"输入不能为空！",
                            confirmButtonColor: "#c04851"
                        })
                    }else{
                        swal({
                            title:"成功",
                            text:"发表成功",
                            confirmButtonColor: "#2894FF"
                        },function (isConfirm){
                            window.location.reload()
                        })
                    }
                }else {
                    swal({
                        title:"错误",
                        type:"warning",
                        text:res.text,
                        confirmButtonColor: "#c04851"
                    })
                }
            }
        })
    })
})

function GetQueryString(name) {
    var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if(r!=null)return  unescape(r[2]); return null;
}