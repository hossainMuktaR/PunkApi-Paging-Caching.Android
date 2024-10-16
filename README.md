# PunkApi-Paging-Caching.Android

PunkApi-Paging-Caching.Android is an Android application that showcases how to implement pagination and caching when consuming the Punk API. This project demonstrates best practices for managing API data efficiently.

## Features

- **Paging**: Efficiently loads data in chunks using the Paging library.
- **Caching**: Stores data locally for offline access and faster retrieval.
- **Clean Architecture**: Follows a clean architecture approach for better maintainability.
- **User-friendly interface**: Provides an intuitive UI for navigating through the data.

## Technologies Used

- **Kotlin**: A modern programming language for Android development.
- **Android Jetpack**: Includes components like Room, LiveData, and ViewModel.
- **Paging Library**: For loading data in pages.
- **Retrofit**: For network operations and API calls.

## App Architecture

This project demonstrates the power of Kotlin Multiplatform by sharing business logic and data layers across Android and iOS. The architecture consists of three main layers:

- **Domain Layer**: Contains business logic and use cases.
- **Data Layer**: Handles data fetching from TheCatAPI using Ktor.
- **Presentation Layer**: Contains Jetpack Compose for Android.
- 
## How It Works
- The app requests a list of cat images from TheCatAPI, handling pagination.
- The data is fetching from PunkApi using Retrofit.
- The UI observes data changes via Kotlin Flow, updating the list as new pages load.


## Acknowledgements
- Punk API for providing the data.
