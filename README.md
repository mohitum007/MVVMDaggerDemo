# MVVM with Dagger and Live Data Demo application.

### Features:

1. Fetching data from server https://stark-spire-93433.herokuapp.com/json
2. Parsing using retrofit and showing in Recycler View.
3. This Demo uses MVVM architecture with Dagger, Rxjava and Live Data
4. Downloading data from url in JSON using retrofit and RxJava.
5. Sorting the product list data is particular order and displaying in recycler view.


## How to run / build / test project

### To run the source code, please follow these steps:

### Import the project:

1. Start Android Studio.

2. From the Welcome screen, click Import project (Eclipse ADT, Gradle, etc.). (if there is already an open project then from the Android Studio menu click File > New > Import Project.)

3. Select the project folder and click Ok and Next.

5. Select the import options and click Finish.


### Set up your device as follows:

1. Connect your device to your development machine with a USB cable. On Windows, please install (if not installed) the appropriate USB driver for your device.

2. Enable USB debugging on your device by going to Settings > Developer options.

Note: On Android 4.2 and newer, Developer options is hidden by default. To make it available, go to Settings > About phone and tap Build number seven times. Return to the previous screen to find Developer options.

### Run the app from Android Studio as follows:

1. In Android Studio, click the app module in the Project window and then select Run > Run.

2. In the Select Deployment Target window, select your device, and click OK.

---

## Main libraries used in the demo:

1. [Retrofit](http://square.github.io/retrofit/)

2. [Dagger](https://google.github.io/dagger/)

3. [RxJava](https://github.com/ReactiveX/RxJava)

3. [LiveData](https://developer.android.com/reference/android/arch/lifecycle/LiveData)