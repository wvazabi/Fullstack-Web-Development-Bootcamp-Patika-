import React from "react";
import trainer1 from "../../assets/trainer1.jpg";
import trainer2 from "../../assets/trainer2.jpg";
import trainer3 from "../../assets/trainer3.jpg";

const Trainers = () => {
  return (
    <div class="trainer-container">
      <div class="trainer-card">
        <div class="line"></div>
        <div class="line-2"></div>
        <div class="line-3"></div>
        <img src={trainer1} alt="Trainer 1" />
        <div class="trainer-layer">
          <h4>Jannie Doe</h4>
          <p>Personal Trainer</p>
        </div>
      </div>
      <div class="trainer-card">
        <div class="line"></div>
        <div class="line-2"></div>
        <div class="line-3"></div>
        <img src={trainer2} alt="Trainer 2" />
        <div class="trainer-layer">
          <h4>John Doe</h4>
          <p>Body Builder</p>
        </div>
      </div>
      <div class="trainer-card">
        <div class="line"></div>
        <div class="line-2"></div>
        <div class="line-3"></div>
        <img src={trainer3} alt="Trainer 3" />
        <div class="trainer-layer">
          <div class="deneme"></div>
          <h4>Jane Doe</h4>
          <p>Cardio Trainer</p>
        </div>
      </div>
    </div>
  );
};

export default Trainers;
