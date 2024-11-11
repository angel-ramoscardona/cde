/*! ******************************************************************************
 *
 * Pentaho
 *
 * Copyright (C) 2024 by Hitachi Vantara, LLC : http://www.pentaho.com
 *
 * Use of this software is governed by the Business Source License included
 * in the LICENSE.TXT file.
 *
 * Change Date: 2028-08-13
 ******************************************************************************/


package pt.webdetails.cdf.dd.reader.factory;

import pt.webdetails.cdf.dd.util.CdeEnvironment;
import pt.webdetails.cdf.dd.util.Utils;
import pt.webdetails.cpf.repository.api.IACAccess;
import pt.webdetails.cpf.repository.api.IRWAccess;
import pt.webdetails.cpf.repository.api.IReadAccess;

public class SolutionResourceLoader implements IResourceLoader {

  private IReadAccess reader;
  private IACAccess accessControl;
  private IRWAccess writer;

  public SolutionResourceLoader() {
  }

  public SolutionResourceLoader( String path ) {
    if ( path.isEmpty() ) {
      this.reader = CdeEnvironment.getUserContentAccess();
    } else {
      this.reader = Utils.getAppropriateReadAccess( path );
    }
    this.writer = Utils.getAppropriateWriteAccess( path );
    this.accessControl = CdeEnvironment.getUserContentAccess();
  }

  public IReadAccess getReader() {
    return this.reader;
  }

  public IACAccess getAccessControl() {
    return this.accessControl;
  }

  public IRWAccess getWriter() {
    return this.writer;
  }

}
