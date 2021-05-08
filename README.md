# owoifyKt
Turning your worst nightmare into a Kotlin package.

[![Maven Central](https://img.shields.io/maven-central/v/io.github.deadshot465/owoifyKt.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22io.github.deadshot465%22%20AND%20a:%22owoifyKt%22)

This is a Kotlin port of [mohan-cao's owoify-js](https://github.com/mohan-cao/owoify-js), which will help you turn any string into nonsensical babyspeak similar to LeafySweet's infamous Chrome extension.

Just like my other Owoify ports, three levels of owoness are available:

1. **owo (default)**: The most vanilla one.
2. **uwu**: The moderate one.
3. **uvu**: Litewawwy unweadabwal.

Please refer to the original [owoify-js repository](https://github.com/mohan-cao/owoify-js) for more information.

Seriously, if you have seen my other ports, you probably have already known the details.

## Reason for development
Because it doesn't seem that Kotlin has any owoify package, and since I have already ported it to several languages, I might as well just keep porting it.

## Install instructions
In your `pom.xml` (Apache Maven):
```xml
<dependency>
  <groupId>io.github.deadshot465</groupId>
  <artifactId>owoifyKt</artifactId>
  <version>1.0</version>
</dependency>
```
In your `build.gradle`:
```gradle
dependencies {
    implementation 'io.github.deadshot465:owoifyKt:1.0'
}
```
In your `build.gradle.kts`:
```kotlin
dependencies {
    implementation("io.github.deadshot465:owoifyKt:1.0")
}

```
In your `build.sbt`:
```scala
libraryDependencies += "io.github.deadshot465" % "owoifyKt" % "1.0"
```
Or the `:dependencies` part in your Clojure project's `project.clj`:
```clojure
:dependencies [
               [io.github.deadshot465/owoifyKt "1.0"]
               ]
```

## Usage
owoifyKt is implemented as a function inside the `Owoifier` object. That means you don't need to create an instance of any class; instead, just call the method `owoify` with the object's name.

Kotlin:
```kotlin
import io.github.deadshot465.owoify.Owoifier
import io.github.deadshot465.owoify.OwoifyLevel

fun main() {
    println(Owoifier.owoify("This is the string to owo! Kinda cute, isn't it?"))
    println(Owoifier.owoify("This is the string to owo! Kinda cute, isn't it?", OwoifyLevel.Uvu))
}

// Example output:
// This is teh stwing two owo! Kinda cute, isn't it?
// fwis is teh stwing two owo(/ =ω=)/ Kinda cute(/ =ω=)/ isn't it?
```

Java:
```java
import io.github.deadshot465.owoify.Owoifier;
import io.github.deadshot465.owoify.OwoifyLevel;

public class Main {
    public static void main(String[] args) {
        System.out.println(Owoifier.INSTANCE.owoify("This is the string to owo! Kinda cute, isn't it?", OwoifyLevel.Owo));
        System.out.println(Owoifier.INSTANCE.owoify("This is the string to owo! Kinda cute, isn't it?", OwoifyLevel.Uvu));
    }
}

// Example output:
// This is teh stwing two owo! Kinda cute, isn't it?
// fwis is teh stwing two owo(/ =ω=)/ Kinda cute(/ =ω=)/ isn't it?
```
In Scala, you can invoke the method in the same manner as Java.

## Disclaimer
As usual, I'm writing this package for both practicing and bots' needs. Performance is **NOT** guaranteed.

That being said, all regular expressions are declared beforehand rather than being declared inside a function. That should be able to avoid the performance cost of building regular expressions every time the method is called.

## See also
- [owoify-js](https://github.com/mohan-cao/owoify-js) - The original owoify-js repository.
- [Owoify.Net](https://www.nuget.org/packages/Owoify.Net) - The C# port of Owoify written by me.
- [Owoify++](https://github.com/deadshot465/OwoifyCpp) - The C++ header-only port of Owoify written by me.
- [owoify_rs](https://crates.io/crates/owoify_rs) - The Rust port of Owoify written by me.
- [owoify-py](https://pypi.org/project/owoify-py/) - The Python port of Owoify written by me.
- [owoify_dart](https://pub.dev/packages/owoify_dart) - The Dart port of Owoify written by me.
- [owoify_rb](https://rubygems.org/gems/owoify_rb) - The Ruby port of Owoify written by me.
- [owoify-go](https://pkg.go.dev/github.com/deadshot465/owoify-go) - The Go port of Owoify written by me.