import React from "react";
import Appointment from "./Appointment";
import Map from "./Map";

const Contact = () => {
  return (
    <div class="contact" id="contact">
      <div class="contact-section">
        <h2>CONTACT US</h2>
        <p>
          Lorem ipsum dolor, sit amet consectetur adipisicing elit. Nam iure
          repellendus quisquam eveniet ducimus
        </p>
      </div>
      <div class="contact-menu">
        <Appointment />
        <Map />
      </div>
    </div>
  );
};

export default Contact;
