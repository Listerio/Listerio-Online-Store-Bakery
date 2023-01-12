<%--
  Created by IntelliJ IDEA.
  User: Omotola
  Date: 12/28/2022
  Time: 12:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html><head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css" />

    <!-- font awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/lightgallery-js/1.4.0/css/lightgallery.min.css">
    <link rel="stylesheet" href="includes/style.css">
    <link rel="stylesheet" href="includes/login.css">
</head>
<body style="background: url(ProductImages/gallery1.jpg); background-size:100vw 100vh">
<header class="header">

    <a href="#" class="logo"> <i class="fas fa-bread-slice"></i> bakery </a>
    <jsp:include page="navbar.jsp"></jsp:include>

    <div class="icons">
        <div id="cart-btn" class="fas fa-shopping-cart"></div>
        <div id="menu-btn" class="fas fa-bars"></div>
    </div>

</header>

<div class="loginContainer">
    <div id="formConatainer">
        <h2>Login <span id="cap">Here</span> </h2>
        <form action="LoginServlet" method="post">
            <p style="font-size: 15px">${err}</p>
            <input name="email" id="email" type="text" placeholder="Email">
            <input name="password" id="password" type="text" placeholder="password">
            <button id="login" type="submit">Login</button>
            <div style="text-align: right;"><a href="regis.jsp"> don't have an account</a></div>

        </form>
    </div>
</div>

</body>
</html>