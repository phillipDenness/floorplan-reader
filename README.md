# floor-plan-scanner
 - set TESSDATA_PREFIX environment variable to project tessdata directory

## TODO - Setup pipeline for AWS

## Ubuntu/Mint prequisites
 - Install dependencies:
 - sudo apt-get install tesseract-ocr

 - Download jar tess4J from: https://sourceforge.net/projects/tess4j/
 > Add the jar files for Tess4J via Java Build Path -> Libraries -> Add External JARs

## AWS elastic beanstalk setup
 - ssh to your instance
 - yum groupinstall "Development Tools"
 - sudo wget http://www.leptonica.org/source/leptonica-1.76.0.tar.gz
 - sudo wget sudo wget https://github.com/tesseract-ocr/tesseract/archive/3.05.02.tar.gz


### Install leptonica
 - $ tar xzvf leptonica-1.76.0.tar.gz
 - $ cd leptonica-1.76.0
 - $ ./configure
 - $ make
 - $ sudo make install

### Install tesseract
 - $ tar xzf 3.05.02.tar.gz
 - $ cd tesseract-3.05.02/
 - $ ./autogen.sh
 - $ export PKG_CONFIG_PATH=/usr/local/lib/pkgconfig/
 > Above is a fix from: https://stackoverflow.com/questions/49107733/error-when-installing-tesseract-3-05-in-centos7-error-leptonica-1-74-or-higher
 - $ ./configure
 - $ make
 - $ sudo make install
 - $ ln -s /usr/local/lib/libtesseract.so.3.0.5 /usr/local/lib/tesseract
 - $ sudo ldconfig