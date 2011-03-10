# shredboard

## Description
ShredBoard is an instrument that uses the conventional keyboard and mouse as input. The keys z-/, a-’, q-] and 1-= are mapped to the notes of four guitar strings starting at E, A, D, G for each row of keys. The mouse is mapped for use as an effects pedal. There are 2 effects – <em>ChillZoid</em> - a clean, ambient effect and <em>MightySTOMP</em> - a distorted synth effect. Parameters for each effect can be adjusted with 3 knobs to produce a variety of tones.

## Technical Detail
The software is an AIR application written in ActionScript 3. The sounds are produced in [SuperCollider](http://supercollider.sourceforge.net/) by sending OSC messages via [flosc](http://www.benchun.net/flosc/). The [flosc AS3 classes](http://www.dustypixels.com/blog/2007/03/02/flosc-as3-classes/) were modified for certain OSC messages to work correctly with SuperCollider.

## Installation instructions (Snow Leopard)

1. Copy 'flosc-0.3.1' to '/Applications'
2. Download and install [SuperCollider](http://supercollider.sourceforge.net/)
3. Install 'ShredBoard' by launching 'shredBoard.air'. Uncheck 'Start application after installation'
4. Launch 'SuperCollider' from your 'Applications' folder
5. Open 'shredBoard.sc' in 'SuperCollider'
6. To run the 'shredBoard.sc' program:
7. Hit 'Enter' (NOT 'Return' this would be Fn + ) on lines 1 to 7 - 1 line at a time. If you go beyond line 7 don't worry just continue to the next step
8. When you reach '(', double-click after it to select the entire section within '(' and ')'. Hit 'Enter' (NOT 'Return') again
9. Double-click 'shredBoardFlocServer.command' from the 'installers' directory, to startup 'flosc'. This will open up a 'Terminal' window
10. Launch 'shredBoard' from your 'Applications' folder. If it is already open, restart it.
11. If you hear no sound, quit 'shredBoard' and 'Terminal'. Repeat steps 9 and 10
12. Rock out!

