<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<style type="text/css">
    .bodyDiv{
        border: 2px solid black ;
        border-radius:4%;
        margin-top : 50px;
        margin-bottom : 40px;
        margin-right :15%;
        margin-left :15%;
        padding : 5%;
    }
</style>
<html>
<head>
    <title>DiscordBot TEST</title>
</head>
<body>
<div class="bodyDiv">
    <h3> DISCORD BOT : <span id="botNm">${botNm}</span> </h3>
    <h3> STATUS      : <span id="botStatus">${status}</span>  </h3>
    <h3> 활성버튼      : <button onclick="botStatus('online')">활성화</button>  </h3>
    <h3> 비활성 버튼   : <button onclick="botStatus('offline')">비활성화</button>  </h3>
   <%-- <h3> 이벤트 목록   : <button onclick="eventList()">목록</button>  </h3>--%>
    <textarea onkeypress="" id ="botResult" size="2000" style="width: 636px; height: 269px;" name="bot"></textarea>
</div>
</body>
</html>
<script src="${pageContext.request.contextPath}/webjars/jquery/dist/jquery.min.js"></script>
<script type="text/javascript">
    function botStatus(type) {
        console.log("type : " + type);
        let selectVO = {}   ;

        //조회
        $.ajax({
            url: (type === "online") ? "/discord/setOnline.ajax" : "/discord/setOffline.ajax",
            type: "post",
            contentType: "application/json;charset=utf-8;",
            data: JSON.stringify(selectVO),
            dataType: "json",
            success: function (data) {
             console.log("sueccess");
                console.log("data :"+data);
                console.log("data :"+JSON.stringify(data));
                $("#botNm").text(data.botNm);
                $("#botStatus").text(data.status);
            },
            error: function (request, status, error) {

                console.log("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
            }
        });

    }
    // function eventList (){
    //     $.ajax({
    //         url: "/discord/eventList.ajax",
    //         type: "post",
    //         contentType: "application/json;charset=utf-8;",
    //         data: JSON.stringify({}),
    //         dataType: "json",
    //         success: function (data) {
    //             console.log("sueccess");
    //             console.log("data :"+data);
    //             console.log("data :"+JSON.stringify(data));
    //             $("#botResult").text(data.msg);
    //         },
    //         error: function (request, status, error) {
    //
    //             console.log("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
    //         }
    //     });
    // }

</script>

