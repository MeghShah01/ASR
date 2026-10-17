package Core.IO.File;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;

public class WAVFileHeader implements FileHeader
{
    String identifier, fileFormatID, formatBlockID,dataBlockID;

    int fileSize, blockSize, audioFormat, numberOfChannels,
            sampleRate, bytesPerSecond, bytesPerBlock, bitsPerSample, dataSize;

    WAVFileHeader (byte [] data)
    {
        this.identifier = new String(data, 0, 4, StandardCharsets.US_ASCII);

        this.fileSize = ByteBuffer.wrap(data, 4, 4).order(ByteOrder.LITTLE_ENDIAN).getInt();

        this.fileFormatID = new String(data, 8, 4, StandardCharsets.US_ASCII);

        this.formatBlockID = new String(data, 12, 4, StandardCharsets.US_ASCII);

        this.blockSize = ByteBuffer.wrap(data, 16, 4).order(ByteOrder.LITTLE_ENDIAN).getInt();

        this.audioFormat = ByteBuffer.wrap(data, 20, 2).order(ByteOrder.LITTLE_ENDIAN).getShort() & 0xFFFF;

        this.numberOfChannels = ByteBuffer.wrap(data, 22, 2).order(ByteOrder.LITTLE_ENDIAN).getShort() & 0xFFFF;

        this.sampleRate = ByteBuffer.wrap(data, 24, 4).order(ByteOrder.LITTLE_ENDIAN).getInt();

        this.bytesPerSecond = ByteBuffer.wrap(data, 28, 4).order(ByteOrder.LITTLE_ENDIAN).getInt();

        this.bytesPerBlock = ByteBuffer.wrap(data, 32, 2).order(ByteOrder.LITTLE_ENDIAN).getShort() & 0xFFFF;

        this.bitsPerSample = ByteBuffer.wrap(data, 34, 2).order(ByteOrder.LITTLE_ENDIAN).getShort() & 0xFFFF;

        this.dataBlockID = new String(data, 36, 4, StandardCharsets.US_ASCII);

        this.dataSize = ByteBuffer.wrap(data, 40, 4).order(ByteOrder.LITTLE_ENDIAN).getInt();
    }

    @Override
    public String getIdentifier()
    {
        return identifier;
    }

    @Override
    public String getFileFormatID()
    {
        return fileFormatID;
    }

    @Override
    public String getFormatBlockID()
    {
        return formatBlockID;
    }

    @Override
    public String getDataBlockID()
    {
        return dataBlockID;
    }

    @Override
    public int getFileSize()
    {
        return fileSize;
    }

    @Override
    public int getBlockSize()
    {
        return blockSize;
    }

    @Override
    public int getAudioFormat()
    {
        return audioFormat;
    }

    @Override
    public int getNumberOfChannels()
    {
        return numberOfChannels;
    }

    @Override
    public int getSampleRate()
    {
        return sampleRate;
    }

    @Override
    public int getBytesPerSecond()
    {
        return bytesPerSecond;
    }

    @Override
    public int getBytesPerBlock()
    {
        return bytesPerBlock;
    }

    @Override
    public int getBitsPerSample()
    {
        return bitsPerSample;
    }

    @Override
    public int getDataSize()
    {
        return dataSize;
    }

    @Override
    public String toString ()
    {
        return "Identifiers: " + identifier + "\n" +
                "File Size: " + (fileSize) + " bytes\n" +
                "File Format ID: " + fileFormatID + "\n" +
                "Format Block ID: " + formatBlockID + "\n" +
                "Block Size: " + (blockSize) + " bytes\n" +
                "Audio Format: " + audioFormat + "\n" +
                "Number of Channels: " + numberOfChannels + "\n" +
                "Sample Rate: " + sampleRate + " Hz\n" +
                "Bytes Per Second: " + bytesPerSecond + " bytes/s\n" +
                "Bytes Per Block: " + bytesPerBlock + " bytes/block\n" +
                "Bits Per Sample: " + bitsPerSample + " bits\n" +
                "Data Block ID: " + dataBlockID + "\n" +
                "Data Size: " + dataSize + " bytes\n";
    }
}
