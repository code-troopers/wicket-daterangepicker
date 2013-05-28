# Wicket DateRangePicker integration

Thanks to Cloudbees buildhive for providing a free Jenkins instance. [![Build
Status](https://buildhive.cloudbees.com/job/code-troopers/job/wicket-daterangepicker/badge/icon)](https://buildhive.cloudbees.com/job/code-troopers/job/wicket-daterangepicker/)

[Bootstrap-DateRangePicker](https://github.com/dangrossman/bootstrap-daterangepicker) is a client-side evolved DatePicker .

[Apache Wicket](http://wicket.apache.org) is a Java Web framework providing clean separation between markup and logic.

This project contains a basic integration between Bootstrap-DateRangePicker and Apache Wicket.

# Setup on your project

Add the following Maven dependency

    <dependency>
        <groupId>com.code-troopers</groupId>
        <artifactId>wicket-daterangepicker</artifactId>
        <version>0.2</version>
    </dependency>

To use it in your Wicket application, you will need to attach the `DateRangePickerBehavior` to a `TextField` component.

You can customize the whole set of options provided by the default `Bootstrap-DateRangePicker` javascript plugin by overriding `DateRangePickerBehavior#getPickerOptions()` method.

# JavaScript dependencies

This library depends on momentjs via the artifact deployed on [Webjars](https://github.com/webjars/momentjs). 
This way you can easily use an updated version of the library in your project.
Please notice that the actual version of momentjs deployed on WebJars is missing locale translations, this project includes the french locale.

# Bug tracker

Have a bug? Please create an issue here on GitHub!

https://github.com/code-troopers/wicket-daterangepicker/issues


# Special notes

Thanks to James Ward for the Webjars.org initiative : http://www.jamesward.com/2012/10/31/webjars-officially-launched.

The implementation provided here is open for pull request or further integration into WicketStuff.

# Copyright and license

Copyright 2012 Code-Troopers.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this work except in compliance with the License.
You may obtain a copy of the License in the LICENSE file, or at:

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
