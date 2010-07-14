/*
 * File   : $Source: /alkacon/cvs/opencms/src-modules/org/opencms/gwt/client/ui/Attic/CmsContextMenuItemPanel.java,v $
 * Date   : $Date: 2010/07/14 12:42:17 $
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

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.user.client.ui.HTML;

/**
 * Implements a item panel that wraps the item's HTML.<p>
 * 
 * @author Ruediger Kurz
 */
public class CmsContextMenuItemPanel extends HTML {

    /**
     * The handler for a menu item.<p>
     */
    protected class MenuItemHandler implements ClickHandler, MouseOutHandler, MouseOverHandler {

        /**
         * @see com.google.gwt.event.dom.client.ClickHandler#onClick(com.google.gwt.event.dom.client.ClickEvent)
         */
        @Override
        public void onClick(ClickEvent event) {

            if (m_item.getCommand() != null) {
                m_item.getCommand().execute();
            }
        }

        /**
         * @see com.google.gwt.event.dom.client.MouseOutHandler#onMouseOut(com.google.gwt.event.dom.client.MouseOutEvent)
         */
        public final void onMouseOut(MouseOutEvent event) {

            m_item.onHoverOut(event);
        }

        /**
         * @see com.google.gwt.event.dom.client.MouseOverHandler#onMouseOver(com.google.gwt.event.dom.client.MouseOverEvent)
         */
        public final void onMouseOver(final MouseOverEvent event) {

            m_item.onHoverIn(event);
        }
    }

    /** The menu item. */
    protected CmsContextMenuItem m_item;

    /**
     * Constructor for the menu item panel.<p>
     * 
     * @param item the item
     */
    public CmsContextMenuItemPanel(CmsContextMenuItem item) {

        m_item = item;
        MenuItemHandler handler = new MenuItemHandler();
        addClickHandler(handler);
        addMouseOverHandler(handler);
        addMouseOutHandler(handler);
    }
}
