Server.local.boot;
Server.internal.boot;

//address and port to receive stuff on
n = NetAddr("127.0.0.1", 12000);
~s = Server("myServer", n);
~s.boot;

(
	
	//chillzoid -- parameters --> sustain max 10, speed max 3000, depth max 1000
	SynthDef("chillzoid", { |freq = 440, amp = 0.7, sustain = 2, speed = 5, phase = 0.5, depth = 3, predelay = 0.1|
		var	sig, reverb, mix;
		sig = SinOsc.ar(freq, 0, amp) * EnvGen.kr(Env.perc(0.1, sustain), doneAction: 2);
		reverb = FreeVerb.ar( [sig, DelayC.ar(sig, 0.001, 0.001)], 0.2, 0.1, 0.4 );
		mix = DelayL.ar(reverb, 0.01, SinOsc.kr(speed, phase, depth, predelay)); //speed  phase depth predelay
		Out.ar(0, mix ! 2);
	}).send(~s);
	
	//mightystomp -- parameters --> sustain max 10, preamp max 1000, amp max 1.0, amp max 1.0
	SynthDef("mightystomp", { |freq = 440, amp = 0.4, sustain = 1, slideTime = 0.17, width = 0.15, preamp = 4, detune = 1.005|
		var	sig, sig1, mix, env;
		env = Env.adsr(0.01, 0.03, 0.4, 0.1);
		freq = Lag.kr(freq, slideTime);
		sig1 = SinOsc.ar(freq + .t [0,0.005], 0, amp).cubed.sum * EnvGen.kr(Env.perc(0.1, sustain), doneAction: 2);
		sig1 = (sig1 * preamp).fold2 * amp;
		sig = Mix(VarSaw.ar([freq, freq * detune], 0, width, preamp)).distort * amp 
				* EnvGen.kr(Env.perc(0.1, sustain), doneAction: 2);
		mix = FreeVerb.ar( [sig1 + sig, DelayC.ar(sig1 + sig, 0.001, 0.001)], 0.1, 0.2, 0.4 );
		Out.ar(0, mix ! 2);
	}).send(~s);

	
)

~s.dumpOSC(0);
~s.quit;
~s.free;

//test sounds
~s.sendMsg("/s_new", "chillzoid", s.nextNodeID, 0, 0, \freq, 300, \sustain, 1, \speed, 0.1, \depth, 0.2, \amp, 0.4);
~s.sendMsg("/s_new", "mightystomp", s.nextNodeID, 0, 0, \freq, 100, \sustain, 2, \preamp, 200, \amp, 0.3);

//shut it all down
Server.local.reboot;
Server.internal.reboot;

Server.local.quit;
Server.internal.quit;