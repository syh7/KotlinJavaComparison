# KotlinJavaComparison

This repo is designed to showcase some (not all) differences between Java and Kotlin. Some topics shown are:

### NON-NULLABLE

het belangrijkste: impliciet non-nullable!
Geen nullpointers meer tenzij je expliciet een object nullable maakt!
Verder ook names parameters en default parameter values

### READABLE - MUTABLE SEPARATION

Lists en andere collection implementations zijn impliciet non-mutable. Je moet expliciet MutableList aanmaken om deze te
kunnen wijzigen  
Hetzelfde voor `var` en `val`, `val` is de standaard en non-mutable

### STREAMS

Aantal uitgebreide functies die makkelijker in gebruik zijn dan in Java  
Geen `.stream() ... .toList()` nodig omdat dat impliciet al gebeurt

### INVARIANT ARRAYS

Arrays in Kotlin zijn invariant

- In Java kun je `Array<Super>` = `Array<Child>` doen,
- In Kotlin kun je `Array<Super>` = `Array<Child>` niet doen
- In Kotlin kun je `Array<in Super>` = `Array<Child>` wel doen
- In Kotlin kun je `Array<out Child>` = `Array<Super>` wel doen

### STATIC FUNCTIONS

Kotlin heeft in principe geen static functions  
Deze zijn vervangen door companion object en top level functions.

#### Top-level functies

Kotlin staat toe dat functies (en properties en constanten) _buiten een class_ gedefinieerd worden.

De JVM weet niet wat ie hier mee aan moet, dus de Kotlin compiler genereert een class met statische members voor deze top-level declaraties. Standaard wordt de naam afgeleid van het _bestand_ waar de functies in gedefinieerd zijn. Functies gedefinieerd in `top-level.kt` eindigen als statische methoden in een class genaamd `Top_levelKt`. Als je de naam weet, dan kun je deze in Java importeren. Maar dat is best lelijk. Wil je uitdrukkelijk een class een naam geven, dan kun je de `@file:JvmName` annotatie gebruiken.

#### `object` declaraties

Net zoals top-level functies, kun je in Kotlin functies en properties tot de scope van een class beperken, net zoals Java statics. Kotlin heeft afgekeken van Scala en groepeert deze in een `object` declaratie. Dit type `object` declaratie (in tegenstelling tot een `object` expressie dat een anoniem typetje maakt) definieert een singleton: een type waarvan er maar 1 instantie is, met globale toegang.

* Alle members van zo'n `object` worden gecompileerd tot members van een class met de naam van dit object.
* 👉🏻 Ze zullen nog niet daadwerkelijk _statische methoden_ zijn totdat ze specifiek gemarkeerd zijn met de `@JvmStatic` annotatie. Dit is omdat Kotlin toestaat dat deze objecten afgeleid worden van andere classes en interfaces implementeren, en dat is incompatible met Java's statische declaraties.

#### Companion object

* Wanneer je statische en niet-statische zaken in dezelfde class wil definiëren, dan stop je de _statische_ spullen in een `companion object` in een (overigens niet-statische) class declaratie.
* 👉🏻 Companion objects kunnen ook afgeleid worden van andere classes en interfaces implementeren - weer iets wat Java statics niet kunnen. 

### FUNCTIONS

In Kotlin, functions zijn ook objecten  
Als je een lambda maakt, kan het een lambda zijn (met `.invoke()` en direct aanroepen) of een KFunction (met `.call()`)

### EXCEPTIONS

Er zijn geen checked exceptions in Kotlin
Een idee (het idee) achter checked exceptions is dat de developer er expliciet over moet nadenken wat ie doet met de
exception, en dat ze op een duidelijke manier afgevangen worden
Probleem:

- overal try/catches, ook op plekken waar je zeker weet dat het goed gaat, of throws Exception
- versioning, als je een nieuwe exception toevoegt dan is het een breaking change voor mensen die je library gebruiken
- scalability, als je meerdere

### TYPE CHECKS AND SMART CASTS

If Kotlin knows an object is of a certain type, it will automatically cast it to that object
E.g. if you receive an Interface and find out it is a Child implementation, it will automatically convert it to a Child
object

### RANGE

Kotlin has range examples

- `for (i in 1..10) {`
- `for (i in 1..10 step 2) {`
- `for (i in 1 until 10) {`
- `for (i in 10 downTo 1) {`
- `for (i in (1..10).reversed()) {`
- `for (i in (1..10).filter { it % 2 == 0 }) {`

### DATA CLASS

Kotlin had sinds het begin data class, en Java vond dat zo goed dat ze in Java 14 Record hebben toegevoegd  
Overeenkomsten:

- generated methods: equals, hashCode, toString
- generated constructor
- generated getters (but Kotlin getter is called o.name, while Java uses o.name())
- can modify the canonical constructor
- can add additional methods

Verschillen:

- Data class heeft een copy()
- Record heeft final properties maar data class kan ook non-final hebben
- Record kan niet inheriten, data class wel (ook van non-data classes)
- Record heeft alleen static variables, data class heeft ook mutable properties
