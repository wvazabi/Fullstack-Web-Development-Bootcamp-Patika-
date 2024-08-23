import React, { useState } from "react";
import bmi from "../../assets/bmi-index.jpg";
import arrow from "../../assets/arrow-155-16.png";

const Calculator = () => {
  const [height, setHeight] = useState("");
  const [weight, setWeight] = useState("");

  const calculateBMI = () => {
    console.log("BMI hesapla");
    const bmi = weight / (height / 100) ** 2;

    // BMI'ye göre ok pozisyonunu ayarla
    const arrowImage = document.querySelector(".arrow");
    arrowImage.style.left = calculateLeftFromBMI(bmi) + "%";
  };

  const calculateLeftFromBMI = (bmi) => {
    let leftPosition;

    if (bmi >= 0 && bmi <= 18.5) {
      leftPosition = 14;
    } else if (bmi > 18.5 && bmi <= 24.9) {
      leftPosition = 31;
    } else if (bmi >= 25 && bmi <= 29.9) {
      leftPosition = 47;
    } else if (bmi >= 30 && bmi <= 34.9) {
      leftPosition = 63;
    } else if (bmi >= 35) {
      leftPosition = 80;
    } else {
      leftPosition = 14;
    }

    return leftPosition;
  };

  return (
    <div className="bottom-classes">
      <div className="calculator">
        <h3>BMI Calculator</h3>
        <p>
          Lorem ipsum dolor sit amet consectetur adipisicing elit. Veniam nisi
          vero qui libero provident quod aliquam, tempora, illo laborum quae
          perspiciatis ipsa veritatis temporibus? Id dolor accusamus illum odio
          quam.
        </p>
        <p>
          Lorem ipsum dolor sit amet consectetur, adipisicing elit. Deleniti
          tempora ullam qui porro voluptatum at quis consectetur exercitationem
          alias reprehenderit! Architecto quia, inventore consectetur
          praesentium aperiam eligendi illum fuga molestias?
        </p>
        <div className="calculator-input">
          <div>
            <input
              id="heightInput"
              type="number"
              placeholder="Your Height"
              value={height}
              onChange={(e) => setHeight(e.target.value)}
            />
            <label htmlFor="height">cm </label>
          </div>
          <div>
            <input
              id="weightInput"
              type="number"
              placeholder="Your Weight"
              value={weight}
              onChange={(e) => setWeight(e.target.value)}
            />
            <label htmlFor="weight">kg </label>
          </div>
          <button id="btn-calculate" onClick={calculateBMI}>
            Calculate
          </button>
        </div>
      </div>
      <div className="calculator-img">
        <img src={bmi} alt="BMI index" />
        <img className="arrow" src={arrow} alt="arrow" />
        <div id="trainer"></div>
      </div>
    </div>
  );
};

export default Calculator;
