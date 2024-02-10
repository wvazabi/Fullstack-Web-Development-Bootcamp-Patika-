## Fullstack-Web-Development-Bootcamp-Patika+
# Week 1
- Replit üzerinde asal sayı bulma algoritması geliştirildi
  ```Java
  // Asal sayı hesaplama algoritması
  public class Main {
  public static void main(String[] args) {
  // Sistem for'un max number'ına kadar olan asal sayıların listesini oluşturuyor.
  for(int i = 2; i < 50; i++){
      int a = 0;
    for(int j = 2; j < i; j++){
      if(i % j == 0){
        a = 1;
        break;
      } 
    }
    if(a == 0){
      System.out.println(i);
    }
  } 
  }
  }
```Java 
