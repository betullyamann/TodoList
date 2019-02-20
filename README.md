# TodoList

!! Proje henüz istenen şekilde çalışmamaktadır ve birçok eksiği bulunmaktadır.

Spring Boot, Hibernate, Mysql ve Tyhmeleaf teknolojileri kullanılarak bir todolist uygulaması yazılmaya çalışılmıştır.
Projede modülerliği sağlayabilmek için kullanılan katmanlı mimari yapısı şu şekildedir;

Model -> Uygulama için gereken nesne tanımları bu katmanda yapılmıştır.<br/>
Service -> Model katmanında tanımlanmış olan objeleri alma, oluşturma ve işleme gibi işlemler tanımlanmıştır. <br/>
Controller -> Verilerin gösterilme şartları, kullanımlarına ilişkin metotlar tanımlanmıştır.  <br/>
Dao -> Diğer katmanların veritabanına olan bağımlılığını azaltmak için veritabanı işlemleri soyutlaştırılmıştır.  View -> Kullanıcılara gerekli bilgileri göstermek üzere bir arayüz oluşturulmuştur.

Database tasarımı aşağıdaki gibidir;

![ER Diagram](https://drive.google.com/file/d/1FR5FPa2KDnOyL9ACfSFuCpAsS0ru2cyv/view?usp=sharing)


