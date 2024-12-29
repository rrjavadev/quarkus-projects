# quarkus-demo

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: <https://quarkus.io/>.

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
./mvnw quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at <http://localhost:8080/q/dev/>.

## Packaging and running the application

The application can be packaged using:

```shell script
./mvnw package
```

It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:

```shell script
./mvnw package -Dquarkus.package.jar.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using:

```shell script
./mvnw package -Dnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using:

```shell script
./mvnw package -Dnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/quarkus-demo-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult <https://quarkus.io/guides/maven-tooling>.

## Related Guides

- RESTEasy Reactive ([guide](https://quarkus.io/guides/resteasy-reactive)): A Jakarta REST implementation utilizing build time processing and Vert.x. This extension is not compatible with the quarkus-resteasy extension, or any of the extensions that depend on it.

## Provided Code

### REST

Easily start your REST Web Services

[Related guide section...](https://quarkus.io/guides/getting-started-reactive#reactive-jax-rs-resources)

## TLS Setup

### Step 1: Create or Obtain a JKS File
If you don't already have a JKS file, you can create one using the keytool command:
```shell
keytool -genkeypair -alias mykey -keyalg RSA -keysize 2048 \
  -keystore keystore.jks -validity 365
```
- alias mykey: The alias for the key pair.
- keystore keystore.jks: The name of the JKS file.
- validity 365: The validity period of the certificate in days.

### Step 2: Add the JKS File to Your Project
Place the keystore.jks file in your src/main/resources directory or another accessible location.

### Step 3: Configure Quarkus for HTTPS
Update application.properties file to enable HTTPS and configure it to use the JKS file:
```
# Enable HTTPS
quarkus.http.ssl-port=8443

# JKS file configuration
quarkus.http.ssl.certificate.key-store-file=keystore.jks
quarkus.http.ssl.certificate.key-store-password=<your_keystore_password>

# Optional: Set the key alias (default is the first key in the keystore)
quarkus.http.ssl.certificate.key-store-key-alias=mykey

# Optional: Redirect HTTP traffic to HTTPS
quarkus.http.insecure-requests=redirect

```

### Step 4
Access the endpoint using https://localhost:8443