package Core.IO;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class WAVFileHandler implements FileHandler
{
    private byte [] fileData;

    private byte [] data;

    private WAVFileHeader wavFileHeader;

    private Path filePath;

    public WAVFileHandler (Path filePath)
    {
        this.filePath = filePath;

        try
        {
            this.fileData = Files.readAllBytes(this.filePath);


            this.wavFileHeader = new WAVFileHeader(this.fileData);

            this.data = Arrays.copyOfRange(fileData, 44, fileData.length);

        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
    }

    @Override
    public FileHeader getHeader()
    {
        return this.wavFileHeader;
    }

    public byte[] getData()
    {
        return data;
    }

    public Path getFilePath()
    {
        return filePath;
    }

    @Override
    public String toString ()
    {
        return "WavFile";
    }
}
