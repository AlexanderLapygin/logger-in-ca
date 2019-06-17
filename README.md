# logger-in-ca
Logger on Clean Architecture

Just for CA demo

The simplest (almost) example of Clean Architecture implementation.

The logger is selected as an example. It switches its behavior at runtime.

Features:
- Multiple log writers: console, files, ...
- Filtering by log level: TRACE, DEBUG, INFO, WARN, ERROR, FATAL
- Independent filtering for each log writer
- Changing log writer's behavior at runtime
- ...
