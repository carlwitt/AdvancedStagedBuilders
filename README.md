# AdvancedStagedBuilders
Code Example for Generic Staged Builders

Based on blog post: https://medium.com/linagora-engineering/next-level-java-8-staged-builders-602530f68b75

* The V1 example uses constructors.
* The V2 example uses a builder.
* The V3 example uses a staged builder that has setters for required parameters and forces them to be invoked.
* The V4 example shows how to require either setting both hour and minute or neither.
* The V5 example adds a convenience method that unpacks a LocalDateTime value into the builder's withHour and withMinute methods.

<img width="820" alt="V4andV5" src="https://user-images.githubusercontent.com/956383/169270235-6e7381c2-1f47-41ab-89eb-fe216ffdf7bf.png">
