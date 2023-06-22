# Sodium Blending Registry
This is a plugin for sodium, that fixes a sodium "color blending bug", and adds a dynamic way to register blocks for blending.

## Color blending
"Colors" refers to "color providers" used to colorize block textures.  
Sodium implements a new way to interpolate block colors to make smooth transitions, for example, between two biomes.  
Other than per block, the color is interpolated inside the block itself.

![blending](https://github.com/devpelux/sodium-blendingregistry/raw/806ced3e530523c0f6c34e2351574db8fcc12070/assets/blending.jpg)

## The fix
Sodium interpolates all blocks without discerning if the block really needs this feature or if this causes problems.  
This plugin adds a fix for this, restricting the behaviour only to leaves and some particular blocks.

![issue](https://github.com/devpelux/sodium-blendingregistry/raw/806ced3e530523c0f6c34e2351574db8fcc12070/assets/issue.png)

## The registry
This plugin implements a way to register new blocks for blending.  
If you want to use sodium blending for your blocks, just put your blocks into the tag `c:blendable`.

## References
* [Sodium issue 895](https://github.com/CaffeineMC/sodium-fabric/issues/895): The issue describing the "bug".  
* [Sodium pull request 1360](https://github.com/CaffeineMC/sodium-fabric/pull/1360): The code is taken from there.

# License
Copyright (C) 2023 devpelux (Salvatore Peluso)  
Licensed under MIT license.
