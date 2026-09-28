# Application E-Commerce Micro-services (ecom-ms-app)

Ce dépôt contient la réalisation de l'Activité Pratique N°2 sur l'architecture orientée micro-services avec Spring Boot et Spring Cloud. L'application met en œuvre un système distribué pour la gestion des clients, des produits et de la facturation.

---

## Architecture et Composants du Systeme

L'application est décomposée en plusieurs micro-services et modules d'infrastructure :

* **Discovery Service (Eureka Server)** : Annuaire centralisé assurant l'enregistrement et la découverte dynamique des micro-services (Port : 8761).
* **Config Service (Spring Cloud Config)** : Serveur de configuration centralisé permettant l'externalisation des propriétés à partir d'un dépôt de configuration (Port : 8888).
* **Gateway (Spring Cloud Gateway)** : Passerelle API unique gérant le routage dynamique des requêtes entrantes vers les services appropriés (Port : 8080).
* **Customer Service** : Micro-service dédié à la gestion des clients (Spring Data JPA, Spring Data REST).
* **Inventory Service** : Micro-service dédié à la gestion du catalogue des produits.
* **Billing Service** : Micro-service gérant les factures et les lignes de factures, interconnecté avec les services de gestion des clients et des produits.

---

## Stack Technologique et Rôles des Composants

* **Spring Boot** : Framework de base pour le développement des micro-services.
* **Spring Cloud Config** : Centralisation et gestion unifiée des configurations de l'ensemble des services via un dépôt Git.
* **Netflix Eureka** : Implémentation du service registry pour la découverte dynamique des instances de services.
* **Spring Cloud Gateway** : Point d'entrée unifié et routage dynamique des requêtes.
* **OpenFeign** : Client REST déclaratif utilisé par le Billing Service pour communiquer de manière transparente et synchrone avec le Customer Service et l'Inventory Service.
* **Resilience4j** : Mécanismes de tolérance aux pannes (Circuit Breaker, Rate Limiter) pour empêcher la propagation des défaillances entre les services.
* **Spring Data JPA & H2 / PostgreSQL** : Persistance des données et gestion des bases de données relationnelles.

---

## Ordre de Lancement des Services

Pour garantir le bon fonctionnement de l'infrastructure, il est recommandé de démarrer les composants dans l'ordre suivant :

1. Discovery Service (`discovery-service`)
2. Config Service (`config-service`)
3. Customer Service & Inventory Service
4. Billing Service
5. Gateway (`gateway`)

---
