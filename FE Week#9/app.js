"use strict";

// Array containing class information
const classes = [
  {
    id: 1,
    category: "Yoga",
    img: "/Assets/yoga.jpg",
    desc: "Lorem ipsum dolor sit amet consectetur adipisicing elit. Neque quidem quis earum officiis quam fugit placeat impedit incidunt amet assumenda laboriosam ipsam quisquam perferendis quibusdam, autem, illo eos cupiditate! Debitis aut beatae alias ullam nobis?",
    time: ["Saturday-Sunday: 8:00am - 10.00am", "Monday-Tuesday: 10:00am - 12.00pm", "Wednesday-Friday: 3:00pm - 6.00pm"]
  },
  {
    id: 2,
    category: "Group",
    img: "/Assets/group.webp",
    desc: "Lorem ipsum dolor sit amet consectetur adipisicing elit. Neque quidem quis earum officiis quam fugit placeat impedit incidunt amet assumenda laboriosam ipsam quisquam perferendis quibusdam, autem, illo eos cupiditate! Debitis aut beatae alias ullam nobis?",
    time: ["Saturday-Sunday: 12:00pm - 4.00pm", "Tuesday-Thursday: 2:00pm - 4.00pm", "Wednesday-Friday: 6:00pm - 9.00pm"]
  },
  {
    id: 3,
    category: "Solo",
    img: "/Assets/solo.jpg",
    desc: "Lorem ipsum dolor sit amet consectetur adipisicing elit. Neque quidem quis earum officiis quam fugit placeat impedit incidunt amet assumenda laboriosam ipsam quisquam perferendis quibusdam, autem, illo eos cupiditate! Debitis aut beatae alias ullam nobis?",
    time: ["Saturday-Sunday: 10:00am - 12.00am", "Monday-Tuesday: 12:00pm - 2.00pm", "Wednesday-Friday: 2:00pm - 4.00pm"]
  },
  {
    id: 4,
    category: "Stretching",
    img: "/Assets/stret.webp",
    desc: "Lorem ipsum dolor sit amet consectetur adipisicing elit. Neque quidem quis earum officiis quam fugit placeat impedit incidunt amet assumenda laboriosam ipsam quisquam perferendis quibusdam, autem, illo eos cupiditate! Debitis aut beatae alias ullam nobis?",
    time: ["Saturday-Sunday: 11:00am - 1.00pm", "Tuesday-Thursday: 10:00am - 12.00pm", "Wednesday-Friday: 10:00am - 12.00pm"]
  }
];

// Change the background color of the navbar on scroll and keep it fixed at the top
const navbar = document.querySelector(".navbar");
const navContainer = document.querySelector(".nav-container");
const containerTop = document.querySelector(".container-top");

document.addEventListener("scroll", () => {
  if(window.pageYOffset != 0) {
    navContainer.classList.add("nav-style"); // Add style on scroll
    containerTop.style.paddingTop = "72px"; // Adjust padding for navbar
  } else {
    navContainer.classList.remove("nav-style"); // Remove style when at top
    containerTop.style.paddingTop = "144px"; // Reset padding
  }
})

// Close the navbar menu button on scroll or resize
const checkbox = document.querySelector(".menu-btn");

["resize", "scroll"].forEach((event) =>
  window.addEventListener(event, () => {
    if (checkbox.checked == true) {
      checkbox.checked = false; // Uncheck the menu button
    }
  })
);

// Update content based on button clicks in the Classes section
const groupButton = document.querySelectorAll(".group-btn");
const child = document.querySelectorAll(".group-btn div");
const groupContent = document.querySelector(".group-content");

// Set initial active button style
groupButton[0].style.backgroundColor = "#FE9B01";

// Add event listeners to group buttons
for(let i = 0; i < groupButton.length; i++) {
  groupButton[i].addEventListener("click", () => {
    for(let j = 0; j < groupButton.length; j++) {
      groupButton[j].style.backgroundColor = "#355592"; // Reset button style
      child[j].classList.remove("selection"); // Remove selection class
    } 

    groupButton[i].style.backgroundColor = "#FE9B01"; // Highlight clicked button
    child[i].classList.add("selection"); // Add selection class
    groupContent.innerHTML = ""; // Clear previous content
    const selectedClass = groupButton[i].innerText;

    // Display content based on selected category
    classes.forEach((e) => {
      if(e.category == selectedClass) {
        showMenu(e, groupContent);
      }
    })
  })
}

// Calculate BMI and move the indicator based on input
const arrowUp = document.querySelector(".arrow-up");
const height = document.querySelector("#height");
const weight = document.querySelector("#weight");

weight.addEventListener("input", () => {
  let bmi = weight.value / ((height.value / 100) ** 2);
  let percentage;
  if(bmi > 13.5 && bmi < 18.5) {
    percentage = 7 + (bmi - 13.5) * 16 / 5; // Calculate percentage for low BMI
  } else if(bmi > 25 && bmi < 30 || bmi >= 30 && bmi < 35 || bmi >= 35 && bmi < 40) {
    percentage = 40 + (bmi - 24.5) * 16 / 5; // Calculate percentage for higher BMI
  } else if (bmi >= 18.5 && bmi < 25 ) {
    percentage = 23 + (bmi - 18.5) * 16 / 7; // Calculate percentage for normal BMI
  }

  // Move the indicator if the percentage is within valid range
  if(percentage > 6 && percentage < 88) {
    arrowUp.style.left = `${percentage}%`;
  }
})

// Function to display class menu information
function showMenu(e, groupContent) {
  let div = document.createElement("div");
  div.classList.add("desc");
  div.innerHTML = `<h3>Why are your ${e.category}?</h3>
  <p>
  ${e.desc}
  </p>
  <h3>When comes ${e.category} Your Time.</h3>
  <p>${e.time[0]}</p>
  <p>${e.time[1]}</p>
  <p>${e.time[2]}</p>
</div>`;
  let img = document.createElement("img");
  img.classList.add("class-img");
  img.src = `${e.img}`;
  img.alt = `${e.category}`;
  groupContent.append(div);
  groupContent.append(img);
}

// Show/hide additional information for trainers on hover
const imgBox = document.querySelectorAll(".img-box");
const trainerFlag = document.querySelectorAll(".trainer-flag");
const trainerName = document.querySelectorAll(".trainer-name");

for(let i = 0; i < imgBox.length; i++) {
  imgBox[i].addEventListener ("mouseover", () => {
    trainerFlag[i].classList.remove("hidden"); // Show trainer flag
    trainerName[i].classList.remove("hidden"); // Show trainer name
  })
  imgBox[i].addEventListener ("mouseout", () => {
    trainerFlag[i].classList.add("hidden"); // Hide trainer flag
    trainerName[i].classList.add("hidden"); // Hide trainer name
  })
}
