import React from "react";
import purchase1 from "../../assets/purchase1.jpg";
import purchase2 from "../../assets/purchase2.jpg";
import purchase3 from "../../assets/purchase3.jpg";
import purchase4 from "../../assets/purchase4.jpg";
const Purchase = () => {
  return (
    <div class="purchase-container">
      <div class="purchase-card">
        <img src={purchase1} alt="Purchase 1" />
        <div class="purchase-layer">
          <h4>Kettlebell / 5kg</h4>
          <p>
            <span>89.99$</span> / 59.99$
          </p>
          <div class="price">
            <i class="fa-solid fa-cart-shopping"></i>
            <p> Add To Cart</p>
          </div>
        </div>
      </div>
      <div class="purchase-card">
        <img src={purchase2} alt="Purchase 2" />
        <div class="purchase-layer">
          <h4>Treadmill</h4>
          <p>
            <span>899.99$</span> / 599.99$
          </p>
          <div class="price">
            <i class="fa-solid fa-cart-shopping"></i>
            <p> Add To Cart</p>
          </div>
        </div>
      </div>
      <div class="purchase-card">
        <img src={purchase3} alt="Purchase 3" />
        <div class="purchase-layer">
          <h4>Adjustable Dumbbell</h4>
          <p>
            <span>89.99$</span> / 59.99$
          </p>
          <div class="price">
            <i class="fa-solid fa-cart-shopping"></i>
            <p> Add To Cart</p>
          </div>
        </div>
      </div>
      <div class="purchase-card">
        <img src={purchase4} alt="Purchase 4" />
        <div class="purchase-layer">
          <h4>Kettlebell / 3kg</h4>
          <p>
            <span>89.99$</span> / 59.99$
          </p>
          <div class="price">
            <i class="fa-solid fa-cart-shopping"></i>
            <p> Add To Cart</p>
            <div id="review"></div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Purchase;
