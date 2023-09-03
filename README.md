## Installed PostgreSQL



```bash

Hibernate: 
    drop table if exists student cascade
2023-09-04T01:10:49.779+03:00  WARN 13512 --- [           main] o.h.engine.jdbc.spi.SqlExceptionHelper   : SQL Warning Code: 0, SQLState: 00000
2023-09-04T01:10:49.779+03:00  WARN 13512 --- [           main] o.h.engine.jdbc.spi.SqlExceptionHelper   : tablo "student" mevcut değil, atlanıyor
Hibernate: 
    drop sequence if exists student_sequence
2023-09-04T01:10:49.780+03:00  WARN 13512 --- [           main] o.h.engine.jdbc.spi.SqlExceptionHelper   : SQL Warning Code: 0, SQLState: 00000
2023-09-04T01:10:49.780+03:00  WARN 13512 --- [           main] o.h.engine.jdbc.spi.SqlExceptionHelper   : sequence "student_sequence" mevcut değil, atlanıyor
Hibernate: 
    create sequence student_sequence start with 1 increment by 1
Hibernate: 
    create table student (
        age integer,
        dob date,
        id bigint not null,
        email varchar(255),
        name varchar(255),
        primary key (id)
    )
   ```
Burada eklediğimiz anotasyonlar sayessinde databaseimizde tablelarımız olusuyor.
