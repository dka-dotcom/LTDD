package com.example.ltdd

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

// CLass: SmartDevice
open class SmartDevice(val name: String, val category: String) {

    var deviceStatus = "off"
        protected set

    open val deviceType = "unknown"

    open fun turnOn() {
        deviceStatus = "on"
    }

    open fun turnOff() {
        deviceStatus = "off"
    }
    fun printDeviceInfo() {
        println("Device name: $name, category: $category, type: $deviceType")
    }
}
// Class: SmartTvDevice
class SmartTvDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {

    override val deviceType = "Smart TV"

    private var speakerVolume by RangeRegulator(initialValue = 2, minValue = 0, maxValue = 100)
    private var channelNumber by RangeRegulator(initialValue = 1, minValue = 1, maxValue = 200)

    fun increaseSpeakerVolume() {
        speakerVolume++
        println("Speaker volume increased to $speakerVolume.")
    }

    // decreaseSpeakerVolume
    fun decreaseSpeakerVolume() {
        speakerVolume--
        println("Speaker volume decreased to $speakerVolume.")
    }

    fun nextChannel() {
        channelNumber++
        println("Channel number increased to $channelNumber.")
    }

    // previousChannel
    fun previousChannel() {
        channelNumber--
        println("Channel number decreased to $channelNumber.")
    }

    override fun turnOn() {
        super.turnOn()
        println(
            "$name is turned on. Speaker volume is set to $speakerVolume and channel number is " +
                    "set to $channelNumber."
        )
    }

    override fun turnOff() {
        super.turnOff()
        println("$name turned off")
    }
}

// Class: SmartLightDevice

class SmartLightDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {

    override val deviceType = "Smart Light"

    private var brightnessLevel by RangeRegulator(initialValue = 0, minValue = 0, maxValue = 100)

    fun increaseBrightness() {
        brightnessLevel++
        println("Brightness increased to $brightnessLevel.")
    }

    // decreaseBrightness
    fun decreaseBrightness() {
        brightnessLevel--
        println("Brightness decreased to $brightnessLevel.")
    }

    override fun turnOn() {
        super.turnOn()
        brightnessLevel = 2
        println("$name turned on. The brightness level is $brightnessLevel.")
    }

    override fun turnOff() {
        super.turnOff()
        brightnessLevel = 0
        println("Smart Light turned off")
    }
}
// Class SmartHome (HAS-A)

class SmartHome(
    val smartTvDevice: SmartTvDevice,
    val smartLightDevice: SmartLightDevice
) {

    var deviceTurnOnCount = 0
        private set

    fun turnOnTv() {
        if (smartTvDevice.deviceStatus == "off") {
            smartTvDevice.turnOn()
            deviceTurnOnCount++
        }
    }

    fun turnOffTv() {
        if (smartTvDevice.deviceStatus == "on") {
            smartTvDevice.turnOff()
            deviceTurnOnCount--
        }
    }

    fun increaseTvVolume() {
        if (smartTvDevice.deviceStatus == "on") {
            smartTvDevice.increaseSpeakerVolume()
        }
    }

    // decreaseTvVolume
    fun decreaseTvVolume() {
        if (smartTvDevice.deviceStatus == "on") {
            smartTvDevice.decreaseSpeakerVolume()
        }
    }

    fun changeTvChannelToNext() {
        if (smartTvDevice.deviceStatus == "on") {
            smartTvDevice.nextChannel()
        }
    }

    // changeTvChannelToPrevious
    fun changeTvChannelToPrevious() {
        if (smartTvDevice.deviceStatus == "on") {
            smartTvDevice.previousChannel()
        }
    }

    fun turnOnLight() {
        if (smartLightDevice.deviceStatus == "off") {
            smartLightDevice.turnOn()
            deviceTurnOnCount++
        }
    }

    fun turnOffLight() {
        if (smartLightDevice.deviceStatus == "on") {
            smartLightDevice.turnOff()
            deviceTurnOnCount--
        }
    }

    fun increaseLightBrightness() {
        if (smartLightDevice.deviceStatus == "on") {
            smartLightDevice.increaseBrightness()
        }
    }

    // decreaseLightBrightness
    fun decreaseLightBrightness() {
        if (smartLightDevice.deviceStatus == "on") {
            smartLightDevice.decreaseBrightness()
        }
    }

    fun turnOffAllDevices() {
        turnOffTv()
        turnOffLight()
    }

    // printSmartTvInfo
    fun printSmartTvInfo() {
        smartTvDevice.printDeviceInfo()
    }

    fun printSmartLightInfo() {
        smartLightDevice.printDeviceInfo()
    }
}

class RangeRegulator(
    initialValue: Int,
    private val minValue: Int,
    private val maxValue: Int
) : ReadWriteProperty<Any?, Int> {

    private var fieldData = initialValue

    override fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        return fieldData
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        if (value in minValue..maxValue) {
            fieldData = value
        }
    }
}

fun main() {
    val myTv = SmartTvDevice("Android TV", "Entertainment")
    val myLight = SmartLightDevice("Google Light", "Utility")
    val myHome = SmartHome(myTv, myLight)

    println("--- Turn on TV and Light ---")
    myHome.turnOnTv()
    myHome.turnOnLight()

    println("\n--- Information ---")
    myHome.printSmartTvInfo()
    myHome.printSmartLightInfo()

    println("\n--- TV ---")
    myHome.increaseTvVolume()
    myHome.decreaseTvVolume()
    myHome.changeTvChannelToNext()
    myHome.changeTvChannelToPrevious()

    println("\n--- Light ---")
    myHome.increaseLightBrightness()
    myHome.decreaseLightBrightness()

    println("\n--- Turn Off All Devices  ---")
    myHome.turnOffAllDevices()
}
