import React from "react";
import logo from "../../assets/logo.png";
const Footer = () => {
  return (
    <footer>
      <div class="top-footer">
        <img src={logo} alt="Logo" />
        <p>
          Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptatem
          doloremque dolorum repellendus, eos quas porro quia magni voluptatum
          tenetur, et amet sint numquam animi consectetur! Voluptatem doloremque
          dolorum.
        </p>
      </div>
      <div class="bottom-footer">
        <div class="left-side">
          <h3>Information</h3>
          <a href="#">About Us</a>
          <a href="#">Classes</a>
          <a href="#">Blog</a>
          <a href="#">Contact</a>
        </div>
        <div class="right-side">
          <h3>Helpful Links</h3>
          <a href="#">Services</a>
          <a href="#">Supports</a>
          <a href="#">Terms & Condition</a>
          <a href="#">Privacy Policy</a>
        </div>
      </div>
    </footer>
  );
};

export default Footer;
