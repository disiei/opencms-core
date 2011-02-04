/*
 * File   : $Source: /alkacon/cvs/opencms/src-modules/org/opencms/gwt/client/ui/Attic/CmsErrorDialog.java,v $
 * Date   : $Date: 2011/02/04 08:36:01 $
 * Version: $Revision: 1.1 $
 *
 * This library is part of OpenCms -
 * the Open Source Content Management System
 *
 * Copyright (C) 2002 - 2009 Alkacon Software (http://www.alkacon.com)
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * For further information about Alkacon Software, please see the
 * company website: http://www.alkacon.com
 *
 * For further information about OpenCms, please see the
 * project website: http://www.opencms.org
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */

package org.opencms.gwt.client.ui;

import org.opencms.gwt.client.Messages;
import org.opencms.gwt.client.ui.css.I_CmsLayoutBundle;
import org.opencms.gwt.client.util.CmsClientStringUtil;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Panel;

/**
 * Provides a generic error dialog.<p>
 * 
 * @author Tobias Herrmann
 * 
 * @version $Revision: 1.1 $
 * 
 * @since 8.0.0
 */
public class CmsErrorDialog extends CmsPopupDialog {

    /** The 'close' button. */
    private CmsPushButton m_closeButton;

    /**
     * Constructor.<p>
     * 
     * @param t the error to notify to the user
     */
    public CmsErrorDialog(Throwable t) {

        super();
        setAutoHideEnabled(false);
        setModal(true);
        setGlassEnabled(true);
        setText(Messages.get().key(Messages.GUI_ERROR_0));
        m_closeButton = new CmsPushButton();
        m_closeButton.setText(Messages.get().key(Messages.GUI_OK_0));
        m_closeButton.setUseMinWidth(true);
        m_closeButton.addClickHandler(new ClickHandler() {

            /**
             * @see com.google.gwt.event.dom.client.ClickHandler#onClick(com.google.gwt.event.dom.client.ClickEvent)
             */
            public void onClick(ClickEvent event) {

                onClose();
            }
        });
        addButton(m_closeButton);

        Panel content = new FlowPanel();
        content.add(new HTML(
            Messages.get().key(Messages.GUI_TICKET_MESSAGE_2, CmsClientStringUtil.getMessage(t), "xxx")));
        CmsFieldSet fieldset = new CmsFieldSet();
        fieldset.addStyleName(I_CmsLayoutBundle.INSTANCE.errorDialogCss().details());
        fieldset.setLegend("Details");
        fieldset.addContent(new HTML(CmsClientStringUtil.getStackTrace(t, "<br />\n")));
        fieldset.setCollapsed(true);
        content.add(fieldset);
        setContent(content);
    }

    /**
     * Executed on 'close' click. <p>
     */
    protected void onClose() {

        m_closeButton.setEnabled(false);
        hide();
    }
}
