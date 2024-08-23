import React from "react";
import yoga from "../../assets/yoga.jpg";
import solo from "../../assets/solo.jpg";
import group from "../../assets/group.webp";
import stret from "../../assets/stret.webp";

const Info = ({ selectedType }) => {
  return (
    <div>
      {selectedType === "Yoga" ? (
        <div className="info" id="info-yoga">
          <div className="left-info">
            <h3>Why Are Your Yoga?</h3>
            <p>
              Lorem ipsum dolor, sit amet consectetur adipisicing elit.
              Quibusdam id delectus ullam quasi ex. A quasi libero eum, neque
              corporis iste mollitia voluptatum in, tenetur, earum inventore
              quos maiores hic.
            </p>

            <h3>When Comes Yoga Your Time.</h3>
            <p>Saturday-Sunday: 08:00 - 10:00</p>
            <p>Monday-Tuesday: 10:00 - 12:00</p>
            <p>Wednesday-Friday: 15:00 - 18:00</p>
          </div>
          <div className="right-info">
            <img src={yoga} alt="Yogi" />
          </div>
        </div>
      ) : null}
      {selectedType === "Group" ? (
        <div className="info" id="info-group">
          <div className="left-info">
            <h3>Why Are Your Group?</h3>
            <p>
              Lorem ipsum dolor, sit amet consectetur adipisicing elit.
              Quibusdam id delectus ullam quasi ex. A quasi libero eum, neque
              corporis iste mollitia voluptatum in, tenetur, earum inventore
              quos maiores hic.
            </p>

            <h3>When Comes Group Your Time.</h3>
            <p>Saturday-Sunday: 09:00 - 11:00</p>
            <p>Monday-Tuesday: 11:00 - 13:00</p>
            <p>Wednesday-Friday: 16:00 - 19:00</p>
          </div>
          <div className="right-info">
            <img src={group} alt="Yogi" />
          </div>
        </div>
      ) : null}
      {selectedType === "Solo" ? (
        <div className="info" id="info-solo">
          <div className="left-info">
            <h3>Why Are Your Solo?</h3>
            <p>
              Lorem ipsum dolor, sit amet consectetur adipisicing elit.
              Quibusdam id delectus ullam quasi ex. A quasi libero eum, neque
              corporis iste mollitia voluptatum in, tenetur, earum inventore
              quos maiores hic.
            </p>

            <h3>When Comes Solo Your Time.</h3>
            <p>Saturday-Sunday: 10:00 - 12:00</p>
            <p>Monday-Tuesday: 12:00 - 14:00</p>
            <p>Wednesday-Friday: 17:00 - 20:00</p>
          </div>
          <div className="right-info">
            <img src={solo} alt="Yogi" />
          </div>
        </div>
      ) : null}
      {selectedType === "Streching" ? (
        <div className="info" id="info-streching">
          <div className="left-info">
            <h3>Why Are Your Streching?</h3>
            <p>
              Lorem ipsum dolor, sit amet consectetur adipisicing elit.
              Quibusdam id delectus ullam quasi ex. A quasi libero eum, neque
              corporis iste mollitia voluptatum in, tenetur, earum inventore
              quos maiores hic.
            </p>
            <h3>When Comes Streching Your Time.</h3>
            <p>Saturday-Sunday: 11:00 - 13:00</p>
            <p>Monday-Tuesday: 13:00 - 15:00</p>
            <p>Wednesday-Friday: 18:00 - 21:00</p>
          </div>
          <div className="right-info">
            <img src={stret} alt="Yogi" />
          </div>
        </div>
      ) : null}
    </div>
  );
};

export default Info;
