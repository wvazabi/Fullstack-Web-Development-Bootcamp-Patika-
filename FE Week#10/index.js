// console.log("Merhaba Dünya");
const personName = "Ahmet";
// let greetingTemplate = `Merhaba ${personName}!`;
// console.log(greetingTemplate);

//  personName = "Mehmet";
// console.log(personName);

// {
//     let personName = "Mehmet";
//     {
//         personName = "Ali";
//         let greetingTemplate = `Merhaba ${personName}!`;
//         {

//         }
//     }
//     greetingTemplate = `Merhaba ${personName}!`;

// }

// const $ = (function jQuery() {
//     var size = 800;
//     function ajax() {
//         console.log("Ajax işlemi yapılıyor...");
//     }

//     return {
//         size: size,
//         ajax: ajax
//     }
// })();

// // modul gibi davranınca uygulamalar kendi modullerini geliştirdi
// $.ajax();
// console.log($.size);

// const personName2 = "Enes";

// // console.log(typeof personName2);

// console.log(typeof null);

// console.log("ilk sırdaki işlem");
// setTimeout(() => {
//     console.log("ikinci sıradaki işlem");
// }, 3000);

//promise

async function main() {
    console.log("ilk sıradaki işlem");
    const result = await new Promise((resolve, reject) => {
        setTimeout(() => {
            resolve("ikinci sıradaki işlem");
        }, 3000);
    });

    console.log(result);
}

main();







