# fintech-app

This project implements a single screen of a Fintech app. There are 3 components of the screen: an insights section that implements stock tickers, a horizontal carousel that contains recent news, and the last section contains a vertical all news section.

# Architecture

<p> ✅ Clean Architecture </p>
<p> ✅ MVVM </p>

# Reactive Programming

<p> ✅ Co-routines </p>
<p> ✅ Flows: good choice to emit/collect data continuously such for stock live market updates. </p>

# Dependency Injection

<p> ✅ Hilt: allows easier setup and easier integration with other Jetpack libraries. </p>

# Data Layer

### Repository
repository created to hold the app's data. The repository contains interfaces and implementations; this was done to follow clean architecture guidelines(separation of concerns) and make the app much more testable.

### CSV Parsing

To parse the CSV data, the OpenCSV library was implemented for its simplicity and the ability to easily read the data and assign it to the data classes with a few lines of code.

### Gson for Json Parsing

Gsn is a popular JSON processing library developed and maintained by Google for reading, writing, and parsing JSON data, easier setup and easier use.

# UI

<p> ✅ Jetpack Compose </p>
<p> ✅ Glide: is a fast and efficient open source media management and image loading framework for Android, Glide's primary focus is on making scrolling any kind of a list of images as smooth and fast as possible </p>

# Unit tests

<p> ✅ Stocks ViewModel unit test </p>


