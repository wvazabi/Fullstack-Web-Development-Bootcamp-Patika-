import React from "react";
import Trainers from "./Trainers";
import Purchase from "./Purchase";
const Trainer = () => {
  return (
    <div class="trainer">
      <div class="top-trainer">
        <div class="trainer-section">
          <h2>OUR BEST TRAINERS</h2>

          <p>
            Lorem ipsum dolor, sit amet consectetur adipisicing elit. Nam iure
            repellendus quisquam eveniet ducimus voluptate eum est perferendis
            nobis! Suscipit!
          </p>
        </div>
        <Trainers />
      </div>
      <div class="bottom-trainer">
        <div class="purchase">
          <div class="purchase-section">
            <h2>PURCHASE FROM US</h2>

            <p>
              Lorem ipsum dolor, sit amet consectetur adipisicing elit. Nam iure
              repellendus quisquam eveniet ducimus voluptate eum est perferendis
              nobis! Suscipit!
            </p>
          </div>
        </div>

        <Purchase />
      </div>
    </div>
  );
};

export default Trainer;
