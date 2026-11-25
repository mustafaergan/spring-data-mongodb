# Spring Data MongoDB Örneği

Spring Boot ile MongoDB'ye kayıt ekleme, okuma ve güncellemeyi gösteren küçük bir REST örneği.
Gömülü belge (kullanıcı içinde grup) ve tekil indeks kullanımı da örneklenir.

> **Not:** Bu depo 2018 yılında eğitim/örnek amaçlı yazıldı ve artık güncellenmiyor. Bağımlılıkları eskidir
> ve bilinen güvenlik açıkları içerir; üretimde kullanmayın.

## İçerik

Proje `mongodb/` klasöründedir.

| Yol | Ne yapar |
|---|---|
| `entity/Test.java` | `test_data` koleksiyonu; `value` alanında tekil indeks (`@Indexed(unique = true)`) |
| `entity/User.java`, `entity/Group.java` | `user` koleksiyonu; grup, kullanıcının içine gömülü belge olarak kaydedilir |
| `repository/` | `MongoRepository` arayüzleri |
| `controller/TestController.java` | `/test/hello?name=...` kayıt ekler, `/test/?id=...` okur, `/test/update?id=...` günceller |
| `controller/UserController.java` | `/user/hello` örnek kullanıcı ekler, `/user/?id=...` okur, `/user/update?id=...` günceller |

Yanıtlar Gson ile JSON'a çevrilir; entity'lerde Lombok `@Data` kullanılır.

## Teknolojiler

- Java 8, Spring Boot 1.5.9 (Web, Data MongoDB)
- Lombok, Gson
- Maven Wrapper (`mvnw`)

## Çalıştırma

1. Yerelde `localhost:27017` üzerinde çalışan bir MongoDB gerekir (ör. `docker run -p 27017:27017 mongo:3.6`).
   Bağlantı ayarları `mongodb/src/main/resources/application.properties` dosyasındadır; veritabanı adı `spring`.
2. Uygulamayı başlatın:

   ```bash
   cd mongodb
   ./mvnw spring-boot:run      # Windows: mvnw.cmd spring-boot:run
   ```

3. Uygulama `8787` portunda açılır, ör. `http://localhost:8787/test/hello?name=deneme`.
