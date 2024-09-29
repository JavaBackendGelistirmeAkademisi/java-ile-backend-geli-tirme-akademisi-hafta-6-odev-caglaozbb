# Freelancer Matching Platform

Freelancer Matching Platform, işverenlerin projeler oluşturup freelancerların teklif vermesine olanak tanıyan bir sistemdir. Bu proje, Spring Boot kullanılarak geliştirilmiş ve PostgreSQL veritabanı ile entegre edilmiştir. 

## Özellikler

- **Kullanıcı Yönetimi**: İşverenler ve freelancerlar için kullanıcı kaydı ve giriş.
- **Proje Yönetimi**: İşverenler projelerini oluşturabilir ve yönetebilir.
- **Teklif Yönetimi**: Freelancerlar projelere teklif verebilir.
- **Ödeme Sistemi**: Ödemelerin durumu takip edilebilir.

## Teknolojiler

- **Backend**: Java, Spring Boot
- **Veritabanı**: PostgreSQL
- **API Dokümantasyonu**: Swagger
- **Docker**: Uygulamanın konteynerleştirilmesi

## Kurulum

### Gereksinimler

- Java 17 veya üstü
- Maven
- Docker (isteğe bağlı)

### Adımlar

1. Projeyi klonlayın:
    ```bash
    git clone https://github.com/kullanici_adiniz/freelancer-matching-platform.git
    ```

2. Proje dizinine gidin:
    ```bash
    cd freelancer-matching-platform
    ```

3. Bağımlılıkları yükleyin:
    ```bash
    mvn install
    ```

4. Uygulamayı başlatın:
    ```bash
    mvn spring-boot:run
    ```

### Docker ile Kurulum

Eğer Docker kullanıyorsanız, şu adımları izleyebilirsiniz:

1. Docker imajını oluşturun:
    ```bash
    docker build -t freelancer-matching-platform .
    ```

2. PostgreSQL veritabanını başlatın:
    ```bash
    docker run --name postgres -e POSTGRES_PASSWORD=mysecretpassword -d postgres
    ```

3. Uygulamayı başlatın:
    ```bash
    docker run --name app --link postgres -p 8080:8080 freelancer-matching-platform
    ```

## API Kullanımı

### Kullanıcı Oluşturma

- **Endpoint**: `POST /api/users`
- **Request Body**:
    ```json
    {
      "name": "cagla",
      "email": "cagla@gmail.com",
      "password": "1caglacagla",
      "userType": "EMPLOYER"
    }
    ```

### Proje Oluşturma

- **Endpoint**: `POST /api/projects`
- **Request Body**:
    ```json
    {
      "title": "Proje Başlığı",
      "description": "Proje Açıklaması",
      "employer": "employer_id"
    }
    ```

## Katkıda Bulunanlar

- Cagla Ozbaba

## Lisans

Bu proje MIT lisansı ile lisanslanmıştır.
