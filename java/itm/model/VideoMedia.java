package itm.model;

/*******************************************************************************
 This file is part of the ITM course 2014
 (c) University of Vienna 2009-2014
 *******************************************************************************/

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;

public class VideoMedia extends AbstractMedia {

	// ***************************************************************
	// Fill in your code here!
	// ***************************************************************

	/* video format metadata */
	protected String videoCodec;
	protected String videoCodecID;
	protected String videoFrameRate;
	protected long videoLength;
	protected int videoHeight;
	protected int videoWidth;

	/* audio format metadata */
	protected String audioCodec;
	protected String audioCodecID;
	protected int audioChannels;
	protected int audioSampleRate;
	protected int audioBitRate;

	/**
	 * Constructor.
	 */
	public VideoMedia() {
		super();
	}

	/**
	 * Constructor.
	 */
	public VideoMedia(File instance) {
		super(instance);
	}

	/* GET / SET methods */

	// ***************************************************************
	// Fill in your code here!
	// ***************************************************************

	public String getVideoCodec() {
		return videoCodec;
	}

	public void setVideoCodec(String videoCodec) {
		this.videoCodec = videoCodec;
	}

	public String getVideoCodecID() {
		return videoCodecID;
	}

	public void setVideoCodecID(String videoCodecID) {
		this.videoCodecID = videoCodecID;
	}

	public String getVideoFrameRate() {
		return videoFrameRate;
	}

	public void setVideoFrameRate(String videoFrameRate) {
		this.videoFrameRate = videoFrameRate;
	}

	public long getVideoLength() {
		return videoLength;
	}

	public void setVideoLength(long videoLength) {
		this.videoLength = videoLength / 1000000;
	}

	public int getVideoHeight() {
		return videoHeight;
	}

	public void setVideoHeight(int videoHeight) {
		this.videoHeight = videoHeight;
	}

	public int getVideoWidth() {
		return videoWidth;
	}

	public void setVideoWidth(int videoWidth) {
		this.videoWidth = videoWidth;
	}

	public String getAudioCodec() {
		return audioCodec;
	}

	public void setAudioCodec(String audioCodec) {
		this.audioCodec = audioCodec;
	}

	public String getAudioCodecID() {
		return audioCodecID;
	}

	public void setAudioCodecID(String audioCodecID) {
		this.audioCodecID = audioCodecID;
	}

	public int getAudioChannels() {
		return audioChannels;
	}

	public void setAudioChannels(int audioChannels) {
		this.audioChannels = audioChannels;
	}

	public int getAudioSampleRate() {
		return audioSampleRate;
	}

	public void setAudioSampleRate(int audioSampleRate) {
		this.audioSampleRate = audioSampleRate * 1000;
	}

	public int getAudioBitRate() {
		return audioBitRate;
	}

	public void setAudioBitRate(int audioBitRate) {
		this.audioBitRate = audioBitRate / 1000;
	}

	/* (de-)serialization */

	/**
	 * Serializes this object to the passed file.
	 * 
	 */
	@Override
	public StringBuffer serializeObject() throws IOException {
		StringWriter data = new StringWriter();
		PrintWriter out = new PrintWriter(data);
		out.println("type: video");
		StringBuffer sup = super.serializeObject();
		out.print(sup);

		/* video fields */

		// ***************************************************************
		// Fill in your code here!
		// ***************************************************************

		out.println();
		out.println("Video-Metadata: ");
		out.println();

		out.println("videoCodec: " + this.videoCodec);
		out.println("videoCodecID: " + this.videoCodecID);
		out.println("videoFrameRate: " + this.videoFrameRate);
		out.println("videoLength [sec]: " + this.videoLength);
		out.println("videoHeight [pixel]: " + this.videoHeight);
		out.println("videoWidth: [pixel]" + this.videoWidth);

		out.println();
		out.println("Audio-Metadata");
		out.println();

		out.println("audioCodec: " + this.audioCodec);
		out.println("audioCodecID: " + this.audioCodecID);
		out.println("audioChannels: " + this.audioChannels);
		out.println("audioSampleRate [Hz]: " + this.audioSampleRate);
		out.println("audioBitRate [kb/s]: " + this.audioBitRate);

		return data.getBuffer();
	}

	/**
	 * Deserializes this object from the passed string buffer.
	 */
	@Override
	public void deserializeObject(String data) throws IOException {
		super.deserializeObject(data);

		StringReader sr = new StringReader(data);
		BufferedReader br = new BufferedReader(sr);
		String line = null;
		while ((line = br.readLine()) != null) {

			/* video fields */

			// ***************************************************************
			// Fill in your code here!
			// ***************************************************************

			if (line.startsWith("videoCodec: ")) {
				this.setVideoCodec(line.substring("videoCodec: ".length()));

			} else if (line.startsWith("videoCodecID: ")) {
				this.setVideoCodecID(line.substring("videoCodecID: ".length()));

			} else if (line.startsWith("videoFrameRate: ")) {
				this.setVideoFrameRate(line.substring("videoFramRate: "
						.length()));

			} else if (line.startsWith("videoLength [sec]: ")) {
				this.setVideoLength(Integer.parseInt(line
						.substring("videoLength [sec]: ".length())) * 1000);

			} else if (line.startsWith("videoHeight [pixel]: ")) {
				this.setVideoHeight(Integer.parseInt(line
						.substring("videoHeight [pixel]: ".length())));

			} else if (line.startsWith("videoWidth [pixel]: ")) {
				this.setVideoWidth(Integer.parseInt(line
						.substring("videoWidth [pixel]: ".length())));

			} else if (line.startsWith("audioCodec: ")) {
				this.setAudioCodec(line.substring("audioCodec: ".length()));

			} else if (line.startsWith("audioCodecID: ")) {
				this.setAudioCodecID(line.substring("audioCodecID: ".length()));

			} else if (line.startsWith("audioChannels: ")) {
				this.setAudioChannels(Integer.parseInt(line
						.substring("audioChannels: ".length())));

			} else if (line.startsWith("audioSampleRate [Hz]: ")) {
				this.setAudioSampleRate(Integer.parseInt(line
						.substring("audioSampleRate [Hz]: ".length())) / 1000);

			} else if (line.startsWith("audioBitRate [kb/s]: ")) {
				this.setAudioBitRate(Integer.parseInt(line
						.substring("audioBitRate [kb/s]: ".length())) * 1000);
			}
		}
	}

}
