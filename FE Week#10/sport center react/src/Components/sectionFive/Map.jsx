import React from "react";

const Map = () => {
  return (
    <div class="map">
      <iframe
        src="//www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d24170.465547236046!2d-74.0069710176553!3d40.77723819999999!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x89c25888aea9541b%3A0xf013bbe795239aa5!2sMomentum%20Fitness!5e0!3m2!1str!2str"
        width="600"
        height="450"
        style={{ border: 0 }}
        allowFullScreen=""
        loading="lazy"
        referrerPolicy="no-referrer-when-downgrade"
      ></iframe>
    </div>
  );
};

export default Map;
