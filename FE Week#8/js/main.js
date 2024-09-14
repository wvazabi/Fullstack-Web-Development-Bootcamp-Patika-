(function () {
  'use strict';
  // katı mode Örneğin, değişkenlerin tanımlanmadan kullanılmasına izin vermez. Yanlışlıkla global değişken yaratma riskini azaltır. Katı mod, sessizce başarısız olan bazı JavaScript işlemlerini, koşulsuz hatalar haline getirir. Bu, hata bulmayı ve düzeltmeyi kolaylaştırır.

  // 1. AOS (Animate On Scroll) kütüphanesinin başlatılması
  // animasyon eklemek için animate on scroll
  AOS.init({
    startEvent: 'load',
    // sayfa yüklendiğinde çalışması
    offset: 20,
    // 100 px 150 px istemiyorum
    once: true,
    // sadece bir kez çalışması tekrar yukarı gidince çalışmasın
  });

  // 2. Swiper kütüphanesi kullanılarak kamera bölümünün başlatılması
  // kamera id li div in içinde swiper sınıflı elementi seçiyoruz slider için kapsayıcı div diyoruz
  //speed geçiş süresi 600 ms spacebetwen slide arası boşluk
  // new diyerek swiper kodlarından bir nesne olusturarak cameraya atıyoruz
  var camera = new Swiper('#camera .swiper', {
    speed: 600,
    spaceBetween: 12,
    navigation: {
      enabled: true,
      // sol buton burası sağ buton burası diye belirtmek için  
      nextEl: '.swiper-button-next',
      prevEl: '.swiper-button-prev',
    }
  });

  // 3. GLightbox kütüphanesi kullanılarak genel lightbox (açılır görsel gösterici) başlatılması
  
  var glightbox = GLightbox({
    selector: '.glightbox',
  })

  // 4. GLightbox kütüphanesi kullanılarak fotoğraflar lightbox başlatılması
  var photos = GLightbox({
    selector: '#photos .photo',
  });

  // 5. Swiper kütüphanesi kullanılarak yorumlar bölümü başlatılması
  // swiper codelarını swiper dokumanlarından kontrol edilerek yazabiliyoruz
  // el ile seçiciyi veriyoruz
  var comment = new Swiper('#comments .swiper', {
    pagination: {
      el: '.swiper-pagination',
      clickable: true,
      type: 'bullets',
    }
  });

  // 6. Header (üst bilgi) elementini almak
  // nacbardaki  başllıkları seçmek için header seçiçisi oluştuyuyoruz elemente göre ıd yi getir
  // hearder elementini alıyoruz
  var header = document.getElementById('header');

  // 7. Header'ın kaydırıldığında eklenmesi ve kaldırılması gereken sınıf
  // sayfa kaydırıldıgında scroll eklenmesi ve çıkartılması
  var headerScrolledHandler = function () {
    if (window.scrollY > 100) {
      header.classList.add('header-scrolled');
    } else {
      header.classList.remove('header-scrolled');
    }
  }

  // 8. Sayfa yüklendiğinde ve kaydırıldığında headerScrolledHandler'ın çağrılması
  // scroll un elementini takip etmek için 
  // Hem sayfa yenilendiğinde hem de scroll yapıldıgında bu şekilde çalışacak 
  window.addEventListener('load', headerScrolledHandler);
  document.addEventListener('scroll', headerScrolledHandler);

  // 9. Tüm 'scrollto' sınıfına sahip bağlantı elemanlarını almak
  var links = document.getElementsByClassName('scrollto');

  // 10. Her bölüm için doğru linkin odaklanmasını sağlamak
  // tıklayarak veya scrollla haraket edince başlıkların aktifleğinin değişmesi
  var focusSectionLink = function (event) {
    for (const link of links) {
      // tıklanılan eleman IDsi alınıyor #i silmek için ilk karakteri slice yapıyoruz
      var id = link.hash.slice(1);
      var section = document.getElementById(id); 
      // tıklanılan elementi id si camera örneğin #siz
      var position = window.scrollY + (window.innerHeight / 2);
      // posizyon ne zaman hangi bölüm aktif olacagını karar veriyoruz 

      // tıklanılan bölüm varsa kontrolü offsettop section yukarı olan boşluk
      if (position >= section.offsetTop && position <= (section.offsetTop + section.offsetHeight)) {
        link.ariaCurrent = 'page';
        link.classList.add('active');
      } else {
        link.ariaCurrent = null;
        link.classList.remove('active');
      }
    }
  }

  // 11. Bağlantıya tıklandığında ilgili bölüme yumuşak geçiş yapma
  var focusSection = function (event) {
    event.preventDefault();
    var id = event.target.hash.slice(1);
    var section = document.getElementById(id);

    if (section) {
      window.scrollTo({
        top: section.offsetTop - 50,
        behavior: 'smooth',
      })
    }
  }

  // 12. Sayfa kaydırıldığında focusSectionLink'in çağrılması
  window.addEventListener('scroll', focusSectionLink)

  // 13. 'scrollto' sınıfına sahip bağlantılara tıklama olayının eklenmesi
  for (const link of links) {
    link.addEventListener('click', focusSection)
  }

})();