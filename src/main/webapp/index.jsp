<%@ page import="com.example.onlinestore.entities.script.Product" %>
<%@ page import="com.example.onlinestore.services.ProductManagementService" %>
<%@ page import="com.example.onlinestore.services.impl.DefaultProductManagementService" %>
<%@ page import="com.example.onlinestore.entities.script.enums.Category" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ page import="com.example.onlinestore.context.ApplicationContext" %><%--
  Created by IntelliJ IDEA.
  User: Omotola
  Date: 12/28/2022
  Time: 12:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Responsive Bakery Website</title>
  <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css" />

  <!-- font awesome -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">

  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/lightgallery-js/1.4.0/css/lightgallery.min.css">

  <link rel="stylesheet" href="includes/style.css">
</head>
<body>
<%
  ApplicationContext context=(ApplicationContext) request.getSession().getAttribute("applicationContext");
  ProductManagementService service=new DefaultProductManagementService();
  service.init();
  DecimalFormat format=new DecimalFormat("###,###,###.##");
%>
<!-- header -->

<header class="header">
  <%
    String purchase = null;
    if (request.getSession().getAttribute("purchaseSuccessful")!=null){
      purchase= request.getSession().getAttribute("purchaseSuccessful").toString();
      System.out.println("jsp: "+purchase);
    }
  %>
  <p id="purchaseSuccessful" style="display: none;"><%=purchase%></p>
  <a href="#" class="logo"> <i class="fas fa-bread-slice"></i> bakery </a>
  <jsp:include page="navbar.jsp"></jsp:include>

  <div class="icons">
    <div id="cart-btn" class="fas fa-shopping-cart"></div>
    <div id="menu-btn" class="fas fa-bars"></div>
  </div>

</header>

<!-- header end -->

<!-- shopping cart -->

<div class="cart-items-container">

  <div id="close-form" class="fas fa-times"></div>
  <h3 class="title">checkout</h3>

  <%
    for(Product p:context.getSessionCart().getProductList()){
  %>
    <div class="cart-item">
    <a href="remove-from-cart?id=<%=p.getProductId()%>"><span class="fas fa-times"></span></a>
      <img src="<%=p.getProductImageLocation()%>" alt="">
    <div class="content">
      <h3><%=p.getProductName()%></h3>
      <div class="price">$<%=format.format(p.getProductPrice().getPrice())%></div>
    </div>
    </div>
  <%
    }
  %>

  <a href="#order" class="btn"> checkout </a>

</div>

<!-- shopping cart end-->

<!-- home -->

<section class="home" id="home">

  <div class="swiper home-slider">

    <div class="swiper-wrapper">

      <div class="swiper-slide slide" style="background: url(ProductImages/slider1.jpg) no-repeat;">
        <div class="content">
          <h3>we bake the world a better place</h3>
          <a href="#product" class="btn"> get started </a>
        </div>
      </div>

      <div class="swiper-slide slide" style="background: url(ProductImages/slider2.jpg) no-repeat;">
        <div class="content">
          <h3>we bake the world a better place</h3>
          <a href="#" class="btn"> get started </a>
        </div>
      </div>

    </div>

    <div class="swiper-button-next"></div>
    <div class="swiper-button-prev"></div>

  </div>

</section>

<!-- home section ends -->

<!-- banner -->

<section class="banner">
  <img src="ProductImages/banner.png" alt="">
</section>


<!-- banner end-->

<!-- about us -->

<section class="about" id="about">

  <h1 class="heading"> <span>about</span> us </h1>

  <div class="row">

    <div class="image">
      <img src="ProductImages/about.png" alt="">
    </div>

    <div class="content">
      <h3>good things come to those <span>who bake </span> for others</h3>
      <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Velit veritatis sunt id modi quis in eveniet at! Vero iusto excepturi.</p>
      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quisquam molestiae maxime quibusdam rem necessitatibus optio maiores fugiat. Pariatur molestiae.</p>
      <a href="#" class="btn">read more</a>
    </div>

  </div>

</section>


<!-- about us end-->

<!-- product -->

<section class="product" id="product">

  <h1 class="heading">our <span> products</span></h1>

  <div class="box-container">
      <%
      for(Product p:service.getProductByCategory(Category.FOOD)){
      %>
    <div class="box">
      <div class="image">
        <img src="<%=p.getProductImageLocation()%>" alt="">
      </div>
      <div class="content">
        <h3><%=p.getProductName()%></h3>
        <p>${cErr}</p>
        <div class="stars">
          <i class="fas fa-star"></i>
          <i class="fas fa-star"></i>
          <i class="fas fa-star"></i>
          <i class="fas fa-star"></i>
          <i class="fas fa-star"></i>
        </div>
        <span class="price">$<%=format.format(p.getProductPrice().getPrice())%></span>
        <a href="add-to-cart?id=<%=p.getProductId()%>" class="btn">add to cart</a>
      </div>
    </div>
  <%}%>
  </div>
</section>


<!-- product end-->


<!-- gallery -->

<section class="gallery" id="gallery">

  <h1 class="heading">our <span> gallery</span></h1>

  <div class="gallery-container">

    <a href="ProductImages/gallery1.jpg" class="box">
      <img src="ProductImages/gallery1.jpg" alt="">
      <div class="icons"><i class="fas fa-plus"></i></div>
    </a>

    <a href="ProductImages/gallery2.jpg" class="box">
      <img src="ProductImages/gallery2.jpg" alt="">
      <div class="icons"><i class="fas fa-plus"></i></div>
    </a>

    <a href="ProductImages/gallery3.jpg" class="box">
      <img src="ProductImages/gallery3.jpg" alt="">
      <div class="icons"><i class="fas fa-plus"></i></div>
    </a>

    <a href="ProductImages/gallery4.jpg" class="box">
      <img src="ProductImages/gallery4.jpg" alt="">
      <div class="icons"><i class="fas fa-plus"></i></div>
    </a>

    <a href="ProductImages/gallery5.jpg" class="box">
      <img src="ProductImages/gallery5.jpg" alt="">
      <div class="icons"><i class="fas fa-plus"></i></div>
    </a>

    <a href="ProductImages/gallery6.jpg" class="box">
      <img src="ProductImages/gallery6.jpg" alt="">
      <div class="icons"><i class="fas fa-plus"></i></div>
    </a>

  </div>

</section>

<!-- gallery end -->

<!-- weekly promotions -->

<section class="promotion">

  <h1 class="heading">weekly <span>promotions</span></h1>

  <div class="box-container">

    <div class="box">
      <div class="content">
        <h3>chocolat cake</h3>
        <p>Lorem, ipsum dolor sit amet consectetur adipisicing elit. Laborum earum tempore rerum totam necessitatibus ipsum.</p>
      </div>

      <img src="ProductImages/promotion1.png" alt="">
    </div>

    <div class="box">
      <img src="ProductImages/promotion2.png" alt="">
      <div class="content">
        <h3>nut cake</h3>
        <p>Lorem, ipsum dolor sit amet consectetur adipisicing elit. Laborum earum tempore rerum totam necessitatibus ipsum.</p>
      </div>

    </div>

  </div>

</section>

<!-- weekly promotions ends -->

<!-- team -->

<section class="team" id="team">

  <h1 class="heading">our  <span>team</span></h1>

  <div class="box-container">

    <div class="box">
      <div class="image">
        <img src="ProductImages/team-1.png" alt="">
      </div>
      <div class="content">
        <h3>erica lacy</h3>
        <p>CEO</p>
        <div class="share">
          <i class="fab fa-facebook-f"></i>
          <i class="fab fa-twitter"></i>
          <i class="fab fa-instagram"></i>
        </div>
      </div>
    </div>

    <div class="box">
      <div class="image">
        <img src="ProductImages/team-2.png" alt="">
      </div>
      <div class="content">
        <h3>doe lacy</h3>
        <p>manager</p>
        <div class="share">
          <i class="fab fa-facebook-f"></i>
          <i class="fab fa-twitter"></i>
          <i class="fab fa-instagram"></i>
        </div>
      </div>
    </div>

    <div class="box">
      <div class="image">
        <img src="ProductImages/team-3.png" alt="">
      </div>
      <div class="content">
        <h3>john lacy</h3>
        <p>manager</p>
        <div class="share">
          <i class="fab fa-facebook-f"></i>
          <i class="fab fa-twitter"></i>
          <i class="fab fa-instagram"></i>
        </div>
      </div>
    </div>

  </div>

</section>

<!-- team -->

<!-- parallax -->

<section class="parallax">

  <h1 class="heading">range of <span>products</span></h1>

  <div class="box-container">

    <div class="box">
      <div class="image">
        <img src="ProductImages/parallax-1.png" alt="">
      </div>
      <div class="content">
        <h3>bread</h3>
        <p>Lorem, ipsum dolor sit amet consectetur adipisicing elit. Ea minus laudantium placeat suscipit.</p>
      </div>
    </div>

    <div class="box">
      <div class="image">
        <img src="ProductImages/parallax-2.png" alt="">
      </div>
      <div class="content">
        <h3>cakes</h3>
        <p>Lorem, ipsum dolor sit amet consectetur adipisicing elit. Ea minus laudantium placeat suscipit.</p>
      </div>
    </div>

    <div class="box">
      <div class="image">
        <img src="ProductImages/parallax-3.png" alt="">
      </div>
      <div class="content">
        <h3>donuts</h3>
        <p>Lorem, ipsum dolor sit amet consectetur adipisicing elit. Ea minus laudantium placeat suscipit.</p>
      </div>
    </div>

  </div>

</section>

<!-- parallax -->

<!-- review -->

<section class="review" id="review">

  <h1 class="heading"> customer's <span>review</span> </h1>

  <div class="box-container">

    <div class="box">
      <img src="ProductImages/review-1.png" class="user" alt="">
      <h3>lacy deo</h3>
      <div class="stars">
        <i class="fas fa-star"></i>
        <i class="fas fa-star"></i>
        <i class="fas fa-star"></i>
        <i class="fas fa-star"></i>
        <i class="fas fa-star-half-alt"></i>
      </div>
      <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Nesciunt qui architecto fuga, voluptatum a deleniti nostrum rerum illum quidem cupiditate odio perspiciatis.</p>
    </div>

    <div class="box">
      <img src="ProductImages/review-2.png" class="user" alt="">
      <h3>lacy deo</h3>
      <div class="stars">
        <i class="fas fa-star"></i>
        <i class="fas fa-star"></i>
        <i class="fas fa-star"></i>
        <i class="fas fa-star"></i>
        <i class="fas fa-star-half-alt"></i>
      </div>
      <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Nesciunt qui architecto fuga, voluptatum a deleniti nostrum rerum illum quidem cupiditate odio perspiciatis.</p>
    </div>

    <div class="box">
      <img src="ProductImages/review-3.png" class="user" alt="">
      <h3>lacy deo</h3>
      <div class="stars">
        <i class="fas fa-star"></i>
        <i class="fas fa-star"></i>
        <i class="fas fa-star"></i>
        <i class="fas fa-star"></i>
        <i class="fas fa-star-half-alt"></i>
      </div>
      <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Nesciunt qui architecto fuga, voluptatum a deleniti nostrum rerum illum quidem cupiditate odio perspiciatis.</p>
    </div>

  </div>

</section>

<!-- review -->

<!-- order -->

<section class="order" id="order">

  <h1 class="heading"><span>order</span> now </h1>

  <div class="row">

    <div class="image">
      <img src="ProductImages/order.gif" alt="">
    </div>

    <form action="OrderServlet" method="post">
      <div class="inputBox">
        <p style="color:red;">${noCI}</p>
        <p style="color: red">${cardErr}</p>
      </div>
      <div class="inputBox">
        <p style="font-size: 20px; font-weight: bold">${cong}</p>
      </div>

      <div class="inputBox">
        <input type="text" placeholder="first name" value="<%=context.getLoggedInUser().getFirstName()%>">
        <input type="text" placeholder="last name" value="<%=context.getLoggedInUser().getLastName()%>">
      </div>

      <div class="inputBox">
        <input type="email" placeholder="email address" value="<%=context.getLoggedInUser().getEmail()%>">
        <input type="number" placeholder="phone number" value="<%=context.getLoggedInUser().getPhoneNumber()%>">
      </div>

      <div class="inputBox">
        <input type="text" placeholder="how much" <% int total=0; for (Product product:context.getSessionCart().getProductList()){
          total+=product.getProductPrice().getPrice();
        }%> value="<%="$"+format.format(total)%>" readonly disabled>
        <input name="cardNumber" type="number" placeholder="Card Number">
      </div>

      <textarea placeholder="your address" name="" id="" cols="30" rows="10"></textarea>
      <input type="submit" value="order now" class="btn">
    </form>

  </div>

</section>

<!-- order end -->

<!-- footer -->

<section class="footer">

  <div class="box-container">

    <div class="box">
      <h3>address</h3>
      <p>Lorem, ipsum dolor sit amet consectetur adipisicing elit. Alias sit debitis.</p>
      <div class="share">
        <a href="#" class="fab fa-facebook-f"></a>
        <a href="#" class="fab fa-twitter"></a>
        <a href="#" class="fab fa-instagram"></a>
        <a href="#" class="fab fa-linkedin"></a>
      </div>
    </div>

    <div class="box">
      <h3>E-mail</h3>
        <a style="text-transform: none" href="#" class="link">Gmail: ayanfeoluwadafidi@gmail.com</a>
        <a style="text-transform: none" href="#" class="link">Outlook: ayanfoluwadafidi@outlook.com</a>
    </div>

    <div class="box">
      <h3>call us</h3>
      <p>+234 8055 1328 00</p>
    </div>

    <div class="box">
      <h3> opening hours</h3>
      <p>Monday - Friday: 9:00 - 23:00 <br> Saturday: 8:00 - 24:00 </p>
    </div>

  </div>

  <div class="credit">created by <span>David</span> all rights reserved! </div>

</section>







<!-- footer ends -->














<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/lightgallery-js/1.4.0/js/lightgallery.min.js"></script>

<script src="includes/script.js"></script>

<script>
  document.getElementById("purchaseSuccessful").onchange=function (){
    var val=  document.getElementById("purchaseSuccessful").innerHTML;
    console.log(val);
    if (val==="true"){
      alert("purchase Successful.\n cart has been cleared");
    }

  }


  lightGallery(document.querySelector('.gallery .gallery-container'));
</script>


</body>
</html>