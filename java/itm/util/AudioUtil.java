package itm.util;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AudioUtil {

	/**
	 * Decodes an Audio-File
	 * 
	 * @param input
	 *            An Audio-File
	 * @param encoding
	 *            AudioFormat.Encoding
	 * @return The decoded AudioInputStream
	 */
	public static AudioInputStream openDecodedAudioInputStream(File input,
			AudioFormat.Encoding encoding) throws IOException,
			UnsupportedAudioFileException {
		// ***************************************************************
		// Fill in your code here!
		// ***************************************************************

		// open audio stream
		AudioInputStream din = AudioSystem.getAudioInputStream(input);

		// get format
		AudioFormat format = din.getFormat();

		// get decoded format
		AudioFormat decoded_format = new AudioFormat(encoding,
				format.getSampleRate(), 16, format.getChannels(),
				format.getChannels() * 2, format.getSampleRate(), false);

		// get decoded audio input stream
		return din = AudioSystem.getAudioInputStream(decoded_format, din);
	}

	/**
	 * Cuts an AudioInputStream from the beginning of the Stream to the
	 * requested length
	 * 
	 * @param audio
	 *            The AudioInputStream to be cut
	 * @param length
	 *            The requested length
	 * @return Cut AudioInputStream
	 */
	public static AudioInputStream cutAudio(AudioInputStream audio, int length) {
		AudioFormat format = audio.getFormat();
		long frames_to_write = length * (int) format.getFrameRate();

		return new AudioInputStream(audio, format, frames_to_write);
	}
}
