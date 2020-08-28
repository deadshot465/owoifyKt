# owoifyKt
Turning your worst nightmare into a Kotlin package.

This is a Kotlin port of [mohan-cao's owoify-js](https://github.com/mohan-cao/owoify-js), which will help you turn any string into nonsensical babyspeak similar to LeafySweet's infamous Chrome extension.

Just like my other Owoify ports, three levels of owoness are available:

1. **owo (default)**: The most vanilla one.
2. **uwu**: The moderate one.
3. **uvu**: Litewawwy unweadabwal.

Please refer to the original [owoify-js repository](https://github.com/mohan-cao/owoify-js) for more information.

Seriously, if you have seen my other ports, you probably have already known the details.

## Reason for development
Because it doesn't seem that Kotlin has any owoify package. And since I have already ported it to several languages, I might as well just keep porting it.

## Install instructions
Put this in your `build.gradle` or `build.gradle.kts`:
```kotlin
repositories {
    maven {
        setUrl("https://dl.bintray.com/chehui-chou/owoifyKt/")
    }
}
```
You might also want to add `jcenter()` to your `settings.gradle` or `settings.gradle.kts`.

Then, add this to your `build.gradle` or `build.gradle.kts` as well.
```kotlin
dependencies {
    implementation("org.deadshot465", "owoifyKt", "1.1")
}
```

## Usage
owoifyKt is implemented as a function inside the `Owoifier` object. That means you don't need to create an instance of any class; instead, just call the method `owoify` with the object's name.

Kotlin:
```kotlin
import org.deadshot465.owoify.Owoifier
import org.deadshot465.owoify.OwoifyLevel

fun main() {
    println(Owoifier.owoify("This is the string to owo! Kinda cute, isn't it?"))
    println(Owoifier.owoify("This is the string to owo! Kinda cute, isn't it?", OwoifyLevel.Uvu))
}

// Output:
// This is teh stwing two owo! Kinda cute, isn't it?
// fwis is teh stwing two owo(/ =ω=)/ Kinda cute(/ =ω=)/ isn't it?
```

Java:
```java
import org.deadshot465.owoify.Owoifier;
import org.deadshot465.owoify.OwoifyLevel;

public class Main {
    public static void main(String[] args) {
        System.out.println(Owoifier.INSTANCE.owoify("This is the string to owo! Kinda cute, isn't it?", OwoifyLevel.Owo));
        System.out.println(Owoifier.INSTANCE.owoify("This is the string to owo! Kinda cute, isn't it?", OwoifyLevel.Uvu));
    }
}

// Output:
// This is teh stwing two owo! Kinda cute, isn't it?
// fwis is teh stwing two owo(/ =ω=)/ Kinda cute(/ =ω=)/ isn't it?
```

## Disclaimer
As usual, I'm writing this package for both practicing and bots' needs. Performance is **NOT** guaranteed.

That being said, all regular expressions are declared beforehand rather than being declared inside a function. That should be able to avoid the performance cost of building regular expressions every time the method is called.

## See also
- [owoify-js](https://github.com/mohan-cao/owoify-js) - The original owoify-js repository.
- [Owoify.Net](https://www.nuget.org/packages/Owoify.Net/1.0.1) - The C# port of Owoify written by me.
- [Owoify++](https://github.com/deadshot465/OwoifyCpp) - The C++ header-only port of Owoify written by me.
- [owoify_rs](https://crates.io/crates/owoify_rs) - The Rust port of Owoify written by me.
- [owoify-py](https://pypi.org/project/owoify-py/) - The Python port of Owoify written by me.
- [owoify_dart](https://pub.dev/packages/owoify_dart) - The Dart port of Owoify written by me.
- [owoify_rb](https://rubygems.org/gems/owoify_rb) - The Ruby port of Owoify written by me.
- [owoify-go](https://github.com/deadshot465/owoify-go) - The Go port of Owoify written by me.