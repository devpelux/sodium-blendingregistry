# Sodium Blending Registry
This is a Sodium plugin designed to address a known bug in the Sodium graphics engine that causes incorrect color blending, resulting in visual inconsistencies in many Minecraft mods which make use of color providers.
The bug is described in [issue 895](https://github.com/CaffeineMC/sodium-fabric/issues/895).

Additionally, it introduces a new tag `c:blendable` that allows custom blocks or fluids to be registered to use the Sodium blending system.

## Examples of the bug
![img1](https://github.com/devpelux/sodium-blendingregistry/raw/d17a1e1ce1b994f4e662ad4223911563fe2a064e/assets/img1.png)

![img2](https://github.com/devpelux/sodium-blendingregistry/raw/d17a1e1ce1b994f4e662ad4223911563fe2a064e/assets/img2.png)

## Installation
To install the mod, follow these steps:

1. Make sure you have Fabric and Sodium installed.
2. Download the correct release of the mod file from Modrinth, for the specific Minecraft and Sodium releases.
3. Move the downloaded mod file into the mods folder.

## Usage of the tag
The `c:blendable` tag can be particularly useful for mod developers when they introduce a block or fluid that utilizes color providers based on the biome.
By applying the tag, the new block or fluid will make use of Sodium blending system instead of the vanilla one.

To use the tag, add a new file named `blendable.json` into `resources/data/c/tags/blocks` for blocks, or `resources/data/c/tags/fluids` for fluids.

The file should be similar to this:

```json
{
  "replace": false,
  "values": [
	"testmod:newleaveblock"
  ]
}
```

Please note that this feature is intended for mod developers and not for end users.

## Bug Reporting
Note that this mod fixes only the blending bug of Sodium.
For other Sodium bugs, please open an issue on Sodium instead and not here!

To ensure accurate bug reporting, please follow these steps:

1. Verify that you are using the correct version of the plugin for the specific Minecraft and Sodium release.
2. Reproduce the issue, noting down any specific steps or circumstances that trigger the bug.
3. Provide any relevant information, including your Minecraft version, Fabric version, Sodium version, and any other mods you have installed.
4. Provide the logs if they are relevant.

## References
* [Sodium issue 895](https://github.com/CaffeineMC/sodium-fabric/issues/895): The issue describing the bug.
* [Sodium pull request 1360](https://github.com/CaffeineMC/sodium-fabric/pull/1360): The code is taken from here.

# License
Copyright (C) 2023 devpelux (Salvatore Peluso)  
Licensed under MIT license.
