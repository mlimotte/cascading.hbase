/*
 * Copyright (c) 2009 Concurrent, Inc.
 *
 * This work has been released into the public domain
 * by the copyright holder. This applies worldwide.
 *
 * In case this is not legally possible:
 * The copyright holder grants any entity the right
 * to use this work for any purpose, without any
 * conditions, unless such conditions are required by law.
 */

package cascading.hbase;

import cascading.flow.Flow;
import cascading.flow.FlowConnector;
import cascading.operation.regex.RegexSplitter;
import cascading.pipe.Each;
import cascading.pipe.Pipe;
import cascading.scheme.TextLine;
import cascading.tap.Lfs;
import cascading.tap.SinkMode;
import cascading.tap.Tap;
import cascading.tuple.Fields;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class MultiFamilyQualifiedFieldMappedTest extends HBaseTestCase
  {
  transient private static Map<Object, Object> properties = new HashMap<Object, Object>();

  String inputFile = "src/test/data/small.txt";

  public MultiFamilyQualifiedFieldMappedTest()
    {
    super( 1, false );
    }

  @Override
  protected void setUp() throws Exception
    {
    super.setUp();
    }

  public void testHBaseMultiFamily() throws IOException
    {
    // create flow to read from local file and insert into HBase
    Tap source = new Lfs( new TextLine(), inputFile );

    Pipe parsePipe = new Each( "insert", new Fields( "line" ),
        new RegexSplitter( new Fields( "fld0", "fld1", "fld2" ), " " ) );

    Fields keyField = new Fields( "fld0" );
    Fields valueFields = new Fields( "fld1", "fld2" );
    String[] qualifiedHBaseColumns = new String[] { "left:lower", "right:upper"};
    Tap hBaseTap = new HBaseTap( "multitable", new HBaseScheme( keyField, valueFields, qualifiedHBaseColumns),
        SinkMode.REPLACE );

    Flow parseFlow = new FlowConnector( properties ).connect( source, hBaseTap, parsePipe );

    parseFlow.complete();

    verifySink( parseFlow, 5 );
    }
  }