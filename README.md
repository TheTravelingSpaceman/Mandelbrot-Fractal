# Mandelbrot-Fractal

Concept
-------
Just some rough java code that draws sections of the [Mandelbrot Set] at different zoom levels. The intention was to do rough multithreading by just running multiple instances of the the program starting at different levels of zoom and stiching it all together using [ffmpeg]. Unfortunately I lost these scripts.

Example Image
-------------
![Why do I need text here?](https://github.com/WalterSmuts/Mandelbrot-Fractal/blob/master/example.png "Example Mandelbrot Render")

Build/Run Instructions
----------------------
```bash
# Download Repo
git clone https://github.com/WalterSmuts/Mandelbrot-Fractal.git
# Change to Cloned directory
cd Mandelbrot-Fractal
# Run make
make
# Change to bin directory
cd bin
# Run main
java main
```

[Mandelbrot Set]: https://en.wikipedia.org/wiki/Mandelbrot_set
[ffmpeg]: https://www.ffmpeg.org/
