using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace LazySharper
{
    class MessageDialogUtils
    {
        public static void ShowErrorMessageDialog(string errorTitle, string errorMessage)
        {
            MessageBox.Show(errorMessage, errorTitle, MessageBoxButtons.OK, MessageBoxIcon.Error);
        }
    }
}
