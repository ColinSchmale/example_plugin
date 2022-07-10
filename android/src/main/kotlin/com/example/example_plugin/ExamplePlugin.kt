package com.example.example_plugin

import androidx.annotation.NonNull

import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result

/** ExamplePlugin */
class ExamplePlugin: FlutterPlugin {
  /// The MethodChannel that will the communication between Flutter and native Android
  ///
  /// This local reference serves to register the plugin with the Flutter Engine and unregister it
  /// when the Flutter Engine is detached from the Activity
  private lateinit var channel : MethodChannel
  private lateinit var channel2 : MethodChannel

  private val firstMethodCallHandler = FirstMethodCallHandler()
  private val secondMethodCallHandler = SecondMethodCallHandler()

  override fun onAttachedToEngine(@NonNull flutterPluginBinding: FlutterPlugin.FlutterPluginBinding) {
    channel = MethodChannel(flutterPluginBinding.binaryMessenger, "example_plugin")
    channel.setMethodCallHandler(firstMethodCallHandler)

    channel2 = MethodChannel(flutterPluginBinding.binaryMessenger, "example_plugin2")
    channel2.setMethodCallHandler(secondMethodCallHandler)
  }

  override fun onDetachedFromEngine(@NonNull binding: FlutterPlugin.FlutterPluginBinding) {
    channel.setMethodCallHandler(null)
    channel2.setMethodCallHandler(null)
  }

  private inner class FirstMethodCallHandler: MethodCallHandler {
    override fun onMethodCall(call: MethodCall, result: Result) {
      if (call.method == "getPlatformVersion") {
        result.success("Android ${android.os.Build.VERSION.RELEASE}")
      } else {
        result.notImplemented()
      }
    }
  }

  private inner class SecondMethodCallHandler: MethodCallHandler {
    override fun onMethodCall(call: MethodCall, result: Result) {
      if (call.method == "getHelloWorld") {
        result.success("Hello World!")
      } else {
        result.notImplemented()
      }
    }
  }
}
