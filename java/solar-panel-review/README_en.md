# Solar Panel Manager

This code is provided for educational purposes, to serve as a discussion support around code approach and software design.

## Context

A solar panel manufacturer has entrusted us with the following mission:

Implement a system that models the behavior of a solar panel.  
This solar panel is equipped with sensors that allow:
* Knowing its real-time production.
* Estimating daily production based on a given date.

## Business rules

The efficiency of the solar panel depends on several parameters:
* Its sun exposure, which corresponds to the percentage of the panel's surface exposed to sunlight.
* The external temperature.
* The night mode.

The following rules apply:

* There is always a 2% energy loss relative to the panel's nominal capacity.
* Above 30°C, the maximum optimal temperature, unfortunately, the panel's performance is reduced by 20%.
* Efficiency is proportional to the surface area of the panel that is exposed to the sun.

Instant production is calculated from the current efficiency.  
The estimated production depends on the number of sunlight hours for the month (provided by an external system certified by the highest authorities and which must not be questioned).

## Add feature

### Add production history

👉 Problem to solve: the class currently only stores instant production.  
👉 Requested change: add a list or data structure to track hourly production of the panel.

### Take weather conditions into account

👉 Problem to solve: the panel currently only considers `sunExposure` and `temp`, but not weather (rain, snow, etc.).  
👉 Requested change: add a `WeatherCondition` class that influences production (`rain`, `snow`, `cloudCover`).