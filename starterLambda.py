print("Start")

from PIL import Image

def toGrayscale(r,g,b):
  return (r,r,r)

def edit(func):
  im =  Image.open("bridge.jpg")
  px = im.load()

  width = im.size[0]
  height = im.size[1]

  for y in range(height):
    for x in range(width):
      rgb = px[x,y]

      r = rgb[0]
      g = rgb[1]
      b = rgb[2]

      if(x < width/2):
        

        newRGB = func(r,g,b)
        px[x,y] = newRGB



  im.save("out.png", "PNG")

  print("Finish")

edit(lambda r,g,b:(r,r,r))
# or edit(toGrayscale)

